package myFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
 
import javax.swing.*;

/*class Node {
	private String id;
	Node(){
		id = "0";
	}
	Node(String id){
		this.id = id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public String getid() {
		return id;
	}
	
}*/

class myPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Point point2,point3;
	public boolean f = false;
	public boolean f1 = false;
	public String n;
	public boolean f2= false;
	public String n1,n2,n3;
	ArrayList<String> N;
	ArrayList<Point> P;
	@SuppressWarnings("rawtypes")
	private Vector shapeVector;
	@SuppressWarnings("rawtypes")
	
	myPanel()
	{   
		point2=point3=new Point(0,0);
		shapeVector = new Vector();
		P=new ArrayList<Point>();
		addMouseListener(
				new MouseAdapter() {
					@SuppressWarnings("unchecked")
					public void mousePressed(MouseEvent e)
					{      if(f) {
						    f=false;
							Rectangle r = new Rectangle(e.getX()-20,e.getY()-20,40,40);
							P.add(e.getPoint());
						    shapeVector.add(r);							
							repaint();
					}
					}
					}
		    );
      }
		/*addMouseMotionListener(
				 new MouseMotionAdapter() {
					public void mouseDragged(MouseEvent event)
					{
						for(int i=0;i<N.size();i++) {
						point2=event.getPoint();
						Rectangle r = new Rectangle(Math.min(point1.x, point2.x),
								                    Math.min(point1.y, point2.y),
								                    Math.abs(point2.x- point1.x),
								                    Math.abs(point2.y- point1.y));
						shapeVector.add(r);
						repaint();
						l1.setText(N1.getid());
					    add(l1);
						
					}
			      }
				}
		 );
	}*/

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Rectangle rec;
		for(int i=0;i<shapeVector.size();i++) {
			g.setColor(Color.black);
			rec = (Rectangle) shapeVector.get(i);
		    g.fillRect(rec.x,rec.y,rec.width,rec.height);
		    g.setColor(Color.RED);
		    g.drawString(N.get(i), rec.x+17, rec.y+23);
		if(f1) {
				    f1 = false;
					int x=N.indexOf(n1);
					int y=N.indexOf(n2);
					point2=	P.get(x);
					point3= P.get(y);
					g.setColor(Color.green);
					g.drawLine(point2.x, point2.y, point3.x, point3.y);
			}
			if(f2) {
				f2= false;
				int x =N.indexOf(n3);
				shapeVector.remove(x);
				P.remove(x);
				N.remove(x);
			}
		}
		
	}
}
public class myFrame extends JFrame implements ActionListener {
   /**
	 * 
	 */
   private static final long serialVersionUID = 1L;
   private JButton b1,b2,b3;
   private JPanel p1;
   ArrayList <String> N ;
   myPanel p2 = new myPanel();
   public myFrame()
     {
	   super("THIS IS SPARTA");
	   N = new ArrayList<String>();
	   p2.N=N;
	   b1 =new JButton("Add New Node");
	   b2 =new JButton("Add New Link");
	   b3 =new JButton("Delete Node");
	   p1 =new JPanel();
	   p1.add(b1);
	   p1.add(b2);
	   p1.add(b3);
	   add(p1,BorderLayout.SOUTH);
	   add(p2,BorderLayout.CENTER);
	   b1.addActionListener(this);
	   b2.addActionListener(this);
	   b3.addActionListener(this);
   }
	   public void actionPerformed(ActionEvent e) {
		   if(e.getSource()==b1) {
			   p2.f=true;
			   String num;
			  num = JOptionPane.showInputDialog("enter the id ");
			  if(N.contains(num)) 
			  {
				  System.out.println("this id already exist");
			  }
			  else {
			  N.add(num);
			  p2.n=num;
			  
		   }
	}
		   else if(e.getSource()==b2) {
			   String num2;
			   String num3;
			   num2 = JOptionPane.showInputDialog("enter the first node id:");
			   num3 = JOptionPane.showInputDialog("enter the Second node id:");
			   if(N.contains(num2)&&N.contains(num3)) {
			   p2.f1 = true;
			   p2.n1=num2;
			   p2.n2=num3;
			   
			   }
			   
			   else {
				   System.out.println("one of the id doesnt exist");
			   }
			   
		   }
		   else {
			   String num4;
			   num4 = JOptionPane.showInputDialog("enter the id:");
				   if(N.contains(num4)) {
					   p2.f2 =true;
					   p2.n3 =num4;
				   }
				   else {
					   System.out.println("this id doesnt exist");
				   }
			   }
		   }

	}

class Test{
	public static void main(String args[])
	    {
			myFrame fr = new myFrame();
			fr.setSize(1000,500);
			fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fr.setVisible(true);
		}
	}





