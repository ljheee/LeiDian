package com.ljheee.plane;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
/**
 * ��Ϸ����
 * @author ljheee
 *
 */
public class WarUI {
	
	private JFrame jf ;
	private static Graphics g;
	private WarUI warui;
	private ImageIcon back;
	private Plane myPlane=new Plane(175,500,60,jf);
	private Plane enemyPlane=new Plane(175,0,60,jf);
	
	int speed=6;
	boolean startPaint = false;
	public WarUI() {
		
		jf = new JFrame("PlaneWar1.0");
		jf.setSize(431,639);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setVisible(true);//����ʾJFrame
		ListenKey listenKey = new ListenKey();
		jf.addKeyListener(listenKey);
		
		paint(g);//���Ʊ���
		
		
	}
	private void paint(Graphics g) {
		g=jf.getGraphics();
		back = new ImageIcon("pic/back.jpg");
		g.drawImage(back.getImage(), 0,0,jf);
		
		myPlane.draw(g);
	
	}
	/**
	 * ���̼�����---���ݼ��̣��ı�ɻ����꣬���ػ�ͼ
	 * @author ljheee
	 *
	 */
	class ListenKey extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			startPaint = true;//����Ϊtrue����ͼ�̣߳���������
			int keyCode = e.getKeyCode();
			switch (keyCode) {
			case KeyEvent.VK_UP:
				myPlane.y-=speed;
				break;
			case KeyEvent.VK_RIGHT:
				myPlane.x+=speed;
				break;
			case KeyEvent.VK_DOWN:
				myPlane.y+=speed;
				break;
			case KeyEvent.VK_LEFT:
				myPlane.x-=speed;
				break;
			default:
				break;
			}
			//
			if(myPlane.x<0||myPlane.y<0||myPlane.x>373||myPlane.y>590){
			}
			System.out.println(myPlane.x+"  "+myPlane.y);
			paint(g);
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			Thread paintThread =new Thread(new PaintThread());
			paintThread.start();
		}
		
	}
	/**
	 * ��ͼ�̣߳�ÿ��tʱ���ػ�
	 * @author ljheee
	 *
	 */
	class PaintThread implements Runnable{

		@Override
		public void run() {
			try {
				while(startPaint){
					System.out.println("paint....");
					jf.repaint();
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		WarUI war = new WarUI();
		
	}
	

}
