NOTEPAD in java
-------------
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Font;
import java.awt.FontMetrics;
class Not extends Frame implements ActionListener {
String TT;
TextArea ta;
Not(String title) {
super(title);
setSize(300,300);

setVisible(true);
MenuBar mbar= new MenuBar();

setMenuBar(mbar);

ta=new TextArea();
Menu file=new Menu("file");
MenuItem i1,i2,i3,i4;
file.add(i1=new MenuItem("open"));
file.add(i2=new MenuItem("save"));
file.add(i3=new MenuItem("new"));
file.add(i4=new MenuItem("quit"));
mbar.add(file);
Menu edit=new Menu("edit");
MenuItem i5,i6,i7,i8,i9;
edit.add(i5=new MenuItem("cut"));
edit.add(i6=new MenuItem("copy"));
edit.add(i7=new MenuItem("paste"));
edit.add(i8=new MenuItem("find"));
edit.add(i9=new MenuItem("replace"));
mbar.add(edit);
Menu foreground=new Menu("foreground");
MenuItem i10,i11,i12;
foreground.add(i10=new MenuItem("red"));
foreground.add(i11=new MenuItem("green"));
foreground.add(i12=new MenuItem("blue"));
mbar.add(foreground);
Menu font=new Menu("font");
MenuItem i13,i14,i15;
font.add(i13=new MenuItem("timesnew roman"));
font.add(i14=new MenuItem("Bradley Hand ITC"));
font.add(i15=new MenuItem("normal"));
mbar.add(font);
Menu background=new Menu("background");
MenuItem i16,i17,i18;
background.add(i16=new MenuItem("bred"));
background.add(i17=new MenuItem("bgreen"));
background.add(i18=new MenuItem("bblue"));
mbar.add(background);




add(ta);
i1.addActionListener(this);
i2.addActionListener(this);
i3.addActionListener(this);
i4.addActionListener(this);
i5.addActionListener(this);
i6.addActionListener(this);
i7.addActionListener(this);
i8.addActionListener(this);
i9.addActionListener(this);
i10.addActionListener(this);
i11.addActionListener(this);
i12.addActionListener(this);
i13.addActionListener(this);
i14.addActionListener(this);
i15.addActionListener(this);
i16.addActionListener(this);
i17.addActionListener(this);
i18.addActionListener(this);
addWindowListener(new MyWindowAdapter());
}
public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(str=="open")
{
String a="";
FileDialog fd=new FileDialog(this,"open");
fd.setVisible(true);
try{
FileInputStream fi=new FileInputStream(fd.getFile());
byte b;
while((b=(byte)fi.read())!=-1)
{
String h=String.valueOf((char)b);
a+=h;
}
ta.setText(a);
}
catch(Exception e) {}
}
else if(str=="save")
{
FileDialog fd=new FileDialog(this,"save",FileDialog.SAVE);
fd.setVisible(true);
try {
FileOutputStream fo=new FileOutputStream(fd.getFile());
fo.write(ta.getText().getBytes());
}
catch(Exception e) {}
}
else if(str=="new")
{
String emp="";
ta.setText(emp);
}
else if(str=="quit")
{
setVisible(false);
System.exit(0);
}
else if(str=="cut")
{

String tot=ta.getText();
String tt=ta.getSelectedText();
int st=ta.getSelectionStart();
int e=ta.getSelectionEnd();
int l=tot.length();
int le=tt.length();
if(st==0)
tot=tot.substring(le,l);
else if(e==1)
tot=tot.substring(0,st);
else
{
String Ryt=tot.substring(e,l);
String Left=tot.substring(0,st);
tot=Left+""+Ryt;
ta.setText(tot);
}}
else if(str=="copy")
{
TT=ta.getSelectedText();

}


else if(str=="paste")
{
ta.insert(TT,ta.getSelectionStart());
}
else if(str=="find")
{
Samdialog sd=new Samdialog(this,"FIND");
sd.setVisible(true);
}
else if(str=="replace")
{
Sad d=new Sad(this,"replace");
d.setVisible(true);
}
else if(str=="red")
{ta.setForeground(Color.red);
}
else if(str=="green")
{ta.setForeground(Color.green);
}
else if(str=="blue")
{ta.setForeground(Color.blue);
}
else if(str=="timesnew roman")
{Font f3= new Font("Times New Roman",Font.BOLD,15);
ta.setFont(f3);
}
else if(str=="Bradley Hand ITC")
{Font f3= new Font("Bradley Hand ITC",Font.ITALIC,15);
ta.setFont(f3);
}
else if(str=="normal")
{Font font1 = new Font("Book Antiqua", Font.PLAIN, 15);
ta.setFont(font1);
}
else if(str=="bred")
{ta.setBackground(Color.red);
}
else if(str=="bgreen")
{ta.setBackground(Color.green);
}
else if(str=="bblue")
{ta.setBackground(Color.blue);
}
}
class Samdialog extends Dialog implements ActionListener {
TextField t1;
Button b1,b2;
Samdialog(Frame f,String str)
{
super(f,str,false);
setLayout(new FlowLayout());
setSize(300,300);
add(t1=new TextField(20));
add(b1=new Button("find"));


add(b2=new Button("cancel"));
b1.addActionListener(this);
b2.addActionListener(this);
}
public void actionPerformed(ActionEvent ae) {
String z=t1.getText();
String taa=ta.getText();
int ind=taa.indexOf(z);
if(ae.getSource()==b1)
{
if(ind==-1) {
t1.setText("not found");
}
else 
{
setVisible(false);
ta.select(ind,ind+z.length());
}}
else
{
setVisible(false);
}}}
class Sad extends Dialog implements ActionListener {
TextField f1,f2;
Button o1,o2;
Sad(Frame f,String st) 
{
super(f,st,false);
setSize(300,300);
setLayout(new FlowLayout());
add(f1=new TextField(20));
add(f2=new TextField(20));
add(o1=new Button("replace"));
add(o2=new Button("cancel"));
o1.addActionListener(this);
o2.addActionListener(this);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==o1)
{
String e=f1.getText();
String r=f2.getText();
String u=ta.getText();
int ind=u.indexOf(e);
if(ind==-1)
{
setVisible(false);
}
else
{
ta.replaceRange(r,ind,ind+e.length());
setVisible(false);
}}
else {
setVisible(false);
}

}}}
class MyWindowAdapter extends WindowAdapter
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}}
public class notepd
{
public static void main(String args[])
{
Not k=new Not("Notepad");
}}


