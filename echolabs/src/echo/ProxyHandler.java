package echo;

import java.net.Socket;

public class ProxyHandler extends RequestHandler {

	protected Correspondent peer;

	public ProxyHandler(Socket s) { super(s); }
	public ProxyHandler() { super(); }

	public void initPeer(String peerHost, int peerPort) {
		peer = new Correspondent();
		peer.requestConnection(peerHost, peerPort);
	}

	protected String response(String msg) throws Exception {
       peer.send(msg); // forward msg to peer
       return peer.receive(); // return peer's response
	}
}
