import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;

public class BTServer implements Runnable {

	// ������֪ͨ ���ڴ���������
	private StreamConnectionNotifier myPCConnNotifier = null;
	// ������
	private StreamConnection streamConn = null;
	// ���������ֽ���
	private byte[] acceptedByteArray = new byte[12];
	// ��ȡ�����룩��
	private InputStream inputStream = null;

	/**
	 * ���߳�
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		new BTServer();
	}

	/**
	 * ���췽��
	 */
	public BTServer() {
		try {
			// �õ�������֪ͨ�������UUID������ֻ��ͻ��˵�UUID��һ�¡�
			myPCConnNotifier = (StreamConnectionNotifier) Connector
					.open("00001101-0000-1000-8000-00805F9B34FB");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ������ͨ������ȡ���߳�
		new Thread(this).start();
	}

	public void run() {
		try {
			String inSTR = null;
			// ���������ż����ͻ��˵���������
			while (true) {
				// ��ȡ������
				streamConn = myPCConnNotifier.acceptAndOpen();
				// ��ȡ��ͨ��
				inputStream = streamConn.openInputStream();
				// ��ȡ�ֽ���
				while (inputStream.read(acceptedByteArray) != -1) {
					inSTR = new String(acceptedByteArray);
					System.out.println(inSTR);
					if (inSTR.contains("EXIT")) {
						// �ֻ��ͻ����˳���ر�����ͨ����
						inputStream.close();
						if (streamConn != null) {
							streamConn.close();
						} 
						break;
					}  
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}