package com.example.quiz;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

    Button b1,b2,b3;
    String s;
    TextView tv;
    SQLiteDatabase db;
    ImageButton ib1,ib2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getIntent().getBooleanExtra("EXIT",false))
        	finish();

        b3=(Button)findViewById(R.id.button3);
        b1=(Button)findViewById(R.id.start);
        b2=(Button)findViewById(R.id.exit);
        tv=(TextView)findViewById(R.id.textView1);
        ib1=(ImageButton)findViewById(R.id.imageButton1);
        ib1.setOnClickListener(this);
        ib2=(ImageButton)findViewById(R.id.imageButton2);
        ib2.setOnClickListener(this);
        registerForContextMenu(b3);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        db=openOrCreateDatabase("quiz_ques",0, null);
        try{
        	db.execSQL("create table tec(ques varchar2(50),ans varchar2(50));");
        	db.execSQL("insert into tec values('Q.MOV extension refers usually to what kind of file?','Animation/movie file')");
        	db.execSQL("insert into tec values('Q.In which decade was the SPICE simulator introduced?','1970s')");
        	db.execSQL("insert into tec values('Q.The purpose of choke in tube light is ?','To increase the voltage momentarily')");
        	db.execSQL("insert into tec values('Q.MPG extension refers usually to what kind of file?','Animation/movie file')");
        	db.execSQL("insert into tec values('Q.Who developed Yahoo?','David Filo & Jerry Yang')");
        	db.execSQL("insert into tec values('Q.What does VVVF stand for?','Variable Voltage Variable Frequency')");
        	db.execSQL("insert into tec values('Q.What does the term PLC stand for?','Programmable Logic Controller')");
        	db.execSQL("insert into tec values('Q.INI extension refers usually to what kind of file?','System file')");
        	db.execSQL("insert into tec values('Q.Who created Pretty Good Privacy (PGP)?','Phil Zimmermann')");
        	db.execSQL("insert into tec values('Q.Who is the developer of Android?','Andy Rubin')");
        	
        	db.execSQL("create table gen(ques varchar2(50),ans varchar2(50));");
        	db.execSQL("insert into gen values('Q.Entomology is the science that studies','Insects')");
        	db.execSQL("insert into gen values('Q.Garampani sanctuary is located at','Diphu, Assam')");
        	db.execSQL("insert into gen values('Q.FFC stands for','Film Finance Corporation')");
        	db.execSQL("insert into gen values('Q.Fastest shorthand writer was','Dr. G. D. Bist')");
        	db.execSQL("insert into gen values('Q.First Afghan War took place in','1839')");
        	db.execSQL("insert into gen values('Q.First China War was fought between','china and britain')");
        	db.execSQL("insert into gen values('Q.Headquarters of UNO are situated at','New York, USA')");
        	db.execSQL("insert into gen values('Q.Epsom(England) is the place associated with','Horse racing')");
        	db.execSQL("insert into gen values('Q.Dr. Zakir Hussain was the first','Muslim president of India')");
        	db.execSQL("insert into gen values('Q.Fathometer is used to measure','ocean depth')");
        	
        	db.execSQL("create table bol(ques varchar2(50),ans varchar2(50));");
        	db.execSQL("insert into bol values('Q.Who is popularly known as Father of Indian Cinema?','Dadasaheb Phalke')");
        	db.execSQL("insert into bol values('Q.Which Indian actor is known as Tragedy King?','Dilip Kumar')");
        	db.execSQL("insert into bol values('Q.Beautiful actress Madhubala was married to …………………….','Kishore Kumar')");
        	db.execSQL("insert into bol values('Q.Shivaji Rao Gaikwad is the real name of which actor?','Rajinikanth')");
        	db.execSQL("insert into bol values('Q.Which of these is not related to Hema Malini?','Sports')");
        	db.execSQL("insert into bol values('Q.Which was the last movie directed by Yash Chopra?','Jab Tak Hai Jaan')");
        	db.execSQL("insert into bol values('Q.First Indian movie submitted for Oscar','mother india')");
        	db.execSQL("insert into bol values('Q.Filmfare awards started in the year','1954')");
        	db.execSQL("insert into bol values('Q.First Indian to win an Oscar award','bhanu athaiya')");
        	db.execSQL("insert into bol values('Q.Doordarshan founded in India in the year','1959')");
            
        }
        catch(Exception e){
        } 
    }  
    public void onCreateContextMenu(ContextMenu menu, View v,
    		ContextMenuInfo menuInfo) {
    	getMenuInflater().inflate(R.menu.mymenu, menu);
    	}
    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	if(item.getItemId()==R.id.tec){
    		s="tec";
    		tv.setText("Get Ready for Technical Quiz");
    	}
    	else if(item.getItemId()==R.id.gen){
    		s="gen";
    		tv.setText("Get Ready for GK Quiz");
    	}
    	else{
    		s="bol";
    		tv.setText("Get Ready for Bollywood Quiz");
    	}
    	return super.onContextItemSelected(item);
    }   
	public void onClick(View v) {
		if(v.getId()==R.id.imageButton1){
			Intent t=new Intent(this,MyService.class);
			startService(t);
		}
		if(v.getId()==R.id.imageButton2){
			Intent t=new Intent(this,MyService.class);
			stopService(t);
		}
		if(v.getId()==R.id.start){ 
			if(s=="tec"){
				Intent i=new Intent(this,Quiz.class);
				i.putExtra("type", s);
				startActivity(i);
			}	
			else if(s=="gen"){
				Intent i=new Intent(this,Quiz.class);
				i.putExtra("type", s);
				startActivity(i);
			}
			else if(s=="bol"){
				Intent i=new Intent(this,Quiz.class);
				i.putExtra("type", s);
				startActivity(i);	
			}
			else
				Toast.makeText(this,"Select Quiz Type!!",Toast.LENGTH_SHORT).show();
		}
		
	    	if(v.getId()==R.id.exit){
			AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
			ab.setTitle("Exit");
			ab.setMessage("Are You Sure?");
			ab.setPositiveButton("I wanna Quit!!",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface arg0, int arg1) {
					db.close();
					finish();					
				}
			});
			ab.setNegativeButton("Take me back..", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface arg0, int arg1) {
					arg0.dismiss();					
				}
			});
			ab.show();		
		}
	}
}
