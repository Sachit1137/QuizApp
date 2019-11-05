package com.example.quiz;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends Activity implements OnClickListener{
	String s,ans;
	int qn[]=new int[10],arr[]=new int[4],strt,crct_ans,wrng_ans;
	Cursor c;
	SQLiteDatabase db;
	Button b1,b2,b3,b4,b5,b6;
	ProgressBar pb;
	TextView t1,t2,t3,t4,t5,t6;
	ImageButton ib;
	boolean timer=true;
	Random r=new Random();
	CountDownTimer counter;
	protected void onCreate(Bundle bun) {
		super.onCreate(bun);
		setContentView(R.layout.activity_quiz);
		Intent i=getIntent();
		bun=i.getExtras();
		s=bun.getString("type");
		db=openOrCreateDatabase("quiz_ques", 0, null);
		b1=(Button) findViewById(R.id.option1);
		b2=(Button) findViewById(R.id.option2);
		b3=(Button) findViewById(R.id.option3);
		b4=(Button) findViewById(R.id.option4);
		b5=(Button) findViewById(R.id.start);
		b6=(Button) findViewById(R.id.next);
		ib=(ImageButton)findViewById(R.id.ib);
		t1=(TextView)findViewById(R.id.textView1);
		t2=(TextView)findViewById(R.id.progress);
		t3=(TextView)findViewById(R.id.result);
		t4=(TextView)findViewById(R.id.textView2);
		t5=(TextView)findViewById(R.id.textView3);
		t6=(TextView)findViewById(R.id.textView4);
		pb=(ProgressBar)findViewById(R.id.progressBar1);
		pb.setProgress(0);
		t2.setText("Completed 0 %");
		ib.setOnClickListener(this);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
	}
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)public void onClick(View v) {
	if(timer==true){
		if(v.getId()==R.id.start ){		
			if(strt==0){
				counter = new CountDownTimer(60000, 1000) { // adjust the milli seconds here
			        @TargetApi(Build.VERSION_CODES.GINGERBREAD) public void onTick(long millisUntilFinished) {
			        t6.setText(""+String.format("%d min, %d sec", 
			                    TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
			                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - 
			                          TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
			    }
			    public void onFinish() {
			       t6.setText("Time Finished!");
			       t6.setTextColor(Color.RED);
			       timer=false;
			    }
			 };
			 counter.start();
				strt=1;
				int ran=r.nextInt(10-0)+0;
				if(s.equals("tec")){
					c=db.rawQuery("select * from tec",null);
					c.moveToFirst();
					if(ran==0){
						qn[0]=1;
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Image file");
						b2.setText("Animation/movie file");
						b3.setText("Audio file");
						b4.setText("MS Office document");
					}
					else if(ran==1){
						qn[1]=1;
						c.moveToPosition(1);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("1970s");
						b2.setText("1950s");
						b3.setText("1980s");
						b4.setText("1960s");
					}
					else if(ran==2){
						qn[2]=1;
						c.moveToPosition(2);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("To decrease the current");
						b2.setText("To increase the current");
						b3.setText("To decrease the voltage momentarily");
						b4.setText("To increase the voltage momentarily");
					}
					else if(ran==3){
						qn[3]=1;
						c.moveToPosition(3);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("WordPerfect Document file");
						b2.setText("MS Office document");
						b3.setText("Animation/movie file");
						b4.setText("Image file");
					}
					else if(ran==4){
						qn[4]=1;
						c.moveToPosition(4);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Dennis Ritchie & Ken Thompson");
						b2.setText("David Filo & Jerry Yang");
						b3.setText("Vint Cerf & Robert Kahn");
						b4.setText("Steve Case & Jeff Bezos");
					}
					else if(ran==5){
						qn[5]=1;
						c.moveToPosition(5);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Variant Voltage Vile FrequencyVery");
						b2.setText("Variable Velocity Variable Fun");
						b3.setText("Very Vicious Frequency");
						b4.setText("Variable Voltage Variable Frequency");
					}
					else if(ran==6){
						qn[6]=1;
						c.moveToPosition(6);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Programmable Lift Computer");
						b2.setText("Program List Control");
						b3.setText("Programmable Logic Controller");
						b4.setText("Piezo Lamp Connector");
					}
					else if(ran==7){
						qn[7]=1;
						c.moveToPosition(7);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Image File");
						b2.setText("System File");
						b3.setText("Hypertext related File");
						b4.setText("None of the above");
					}
					else if(ran==8){
						qn[8]=1;
						c.moveToPosition(8);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Phil Zimmermann");
						b2.setText("Tim Berners-Lee");
						b3.setText("Marc Andreessen");
						b4.setText("Ken Thompson");
					}
					else {
						qn[9]=1;
						c.moveToPosition(9);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Jaun Kaum");
						b2.setText("Mark Zukerberg");
						b3.setText("Larry Page");
						b4.setText("Andy Rubin ");
					}
					ans=c.getString(1);
				}
				else if(s.equals("gen")){
					c=db.rawQuery("select * from gen",null);
					c.moveToFirst();
					if(ran==0){
						qn[0]=1;
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Behavior of human beings");
						b2.setText("Insects");
						b3.setText("The formation of rocks");
						b4.setText("None of the above");
					}
					else if(ran==1){
						qn[1]=1;
						c.moveToPosition(1);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Junagarh, Gujarat");
						b2.setText("Diphu, Assam");
						b3.setText("Kohima, Nagaland");
						b4.setText("Gangtok, Sikkim");
					}
					else if(ran==2){
						qn[2]=1;
						c.moveToPosition(2);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Foreign Finance Corporation");
						b2.setText("Film Finance Corporation");
						b3.setText("Federation of Football Council");
						b4.setText("None of the above");
					}
					else if(ran==3){
						qn[3]=1;
						c.moveToPosition(3);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Dr. G. D. Bist");
						b2.setText("J.R.D. Tata");
						b3.setText("Khudada Khan");
						b4.setText("J.M. Tagore	D.");
					}
					else if(ran==4){
						qn[4]=1;
						c.moveToPosition(4);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("1839");
						b2.setText("1848");
						b3.setText("1843");
						b4.setText("1833");
					}
					else if(ran==5){
						qn[5]=1;
						c.moveToPosition(5);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("China and Britain");
						b2.setText("China and France");
						b3.setText("China and Egypt");
						b4.setText("China and Greek");
					}
					else if(ran==6){
						qn[6]=1;
						c.moveToPosition(6);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("New York, USA");
						b2.setText("Haque (Netherlands)");
						b3.setText("Geneva");
						b4.setText("Paris ");
					}
					else if(ran==7){
						qn[7]=1;
						c.moveToPosition(7);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Horse racing");
						b2.setText("Polo");
						b3.setText("Snooker");
						b4.setText("Shooting");
					}
					else if(ran==8){
						qn[8]=1;
						c.moveToPosition(8);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Muslim president of India");
						b2.setText("vice president of India");
						b3.setText("president of Indian National Congress");
						b4.setText("first speaker of Lok Sabha ");
					}
					else {
						qn[9]=1;
						c.moveToPosition(9);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Earthquakes");
						b2.setText("Rainfall");
						b3.setText("Ocean depth");
						b4.setText("Sound intensity");
					}
					ans=c.getString(1);
				}
				else{
					c=db.rawQuery("select * from bol",null);
					c.moveToFirst();
					if(ran==0){
						qn[0]=1;
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Dadasaheb Phalke");
						b2.setText("V.Shantaram");
						b3.setText("Ardeshir Irani");
						b4.setText("Kidar Sharma");
					}
					else if(ran==1){
						qn[1]=1;
						c.moveToPosition(1);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Sanjeev Kumar");
						b2.setText("Guru Dutt");
						b3.setText("Amitabh Bachchan");
						b4.setText("Dilip Kumar");
					}
					else if(ran==2){
						qn[2]=1;
						c.moveToPosition(2);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Raj Kapoor");
						b2.setText("Dilip Kumar");
						b3.setText("Premnath");
						b4.setText("Kishore Kumar");
					}
					else if(ran==3){
						qn[3]=1;
						c.moveToPosition(3);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Chiranjeevi");
						b2.setText("Rajinikanth	");
						b3.setText("Premnath");
						b4.setText("Nagarjuna");
					}
					else if(ran==4){
						qn[4]=1;
						c.moveToPosition(4);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Politics");
						b2.setText("Dance");
						b3.setText("Sports");
						b4.setText("Bollywood");
					}
					else if(ran==5){
						qn[5]=1;
						c.moveToPosition(5);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Rab Ne Bana Di Jodi");
						b2.setText("Jab Tak Hai Jaan");
						b3.setText("Veer Zara");
						b4.setText("Ek Tha Tiger");
					}
					else if(ran==6){
						qn[6]=1;
						c.moveToPosition(6);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("The Guide");
						b2.setText("Mother India");
						b3.setText("Madhumati");
						b4.setText("Amrapali");
					}
					else if(ran==7){
						qn[7]=1;
						c.moveToPosition(7);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("1952");
						b2.setText("1964");
						b3.setText("1954");
						b4.setText("1960");
					}
					else if(ran==8){
						qn[8]=1;
						c.moveToPosition(8);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("Bhanu athaiya");
						b2.setText("AR Rahman");
						b3.setText("Rasul Pookutty");
						b4.setText("None of the Above");
					}
					else {
						qn[9]=1;
						c.moveToPosition(9);
						String s=c.getString(0);
						t1.setText(s);
						b1.setText("1962");
						b2.setText("1965");
						b3.setText("1952");
						b4.setText("1959");
					}
					ans=c.getString(1);
				}
			}
			else
				Toast.makeText(this, "Quiz has already started...", Toast.LENGTH_SHORT).show();
		}
		if(v.getId()==R.id.option1 && strt==1 ){
			if(arr[0]==0 && arr[1]==0 && arr[2]==0 && arr[3]==0 ){
				arr[0]=1;
				String q=b1.getText().toString();
				if(q.equalsIgnoreCase(ans)){
					b1.setTextColor(Color.GREEN);
					crct_ans++;
					if((crct_ans+wrng_ans)<=10){				
						pb.setProgress((crct_ans*10));					
						t2.setText("Completed "+ crct_ans*10 + "%");
					}
				}
				else{
					b1.setTextColor(Color.RED);
					wrng_ans++;
				}
			}
			
			
		}
		else if(v.getId()==R.id.option2 && strt==1 ){
			if(arr[0]==0 && arr[1]==0 && arr[2]==0 && arr[3]==0){
				arr[1]=1;
				String q=b2.getText().toString();
				if(q.equalsIgnoreCase(ans)){
					b2.setTextColor(Color.GREEN);
					crct_ans++;
					if((crct_ans+wrng_ans)<=10)	{				
						pb.setProgress((crct_ans*10));
						t2.setText("Completed "+ crct_ans*10 + "%");
					}
				}
				else{
					b2.setTextColor(Color.RED);
					wrng_ans++;
				}
			}
			
			}
		else if(v.getId()==R.id.option3 && strt==1 ){
			if(arr[0]==0 && arr[1]==0 && arr[2]==0 && arr[3]==0){
				arr[2]=1;
				String q=b3.getText().toString();
				if(q.equalsIgnoreCase(ans)){
					b3.setTextColor(Color.GREEN);
					crct_ans++;
					if((crct_ans+wrng_ans)<=10){						
						pb.setProgress((crct_ans*10));
						t2.setText("Completed "+ crct_ans*10 + "%");
					}
				}
				else{
					b3.setTextColor(Color.RED);
					wrng_ans++;
				}
			}
			
		}
		else if(v.getId()==R.id.option4 && strt==1 ){
			if(arr[0]==0 && arr[1]==0 && arr[2]==0 && arr[3]==0){
				arr[3]=1;
				String q=b4.getText().toString();
				if(q.equalsIgnoreCase(ans)){
					b4.setTextColor(Color.GREEN);
					crct_ans++;
					if((crct_ans+wrng_ans)<=10)	{					
						pb.setProgress((crct_ans*10));
						t2.setText("Completed "+ crct_ans*10 + "%");
					}
				}
				else{
					b4.setTextColor(Color.RED);
					wrng_ans++;
				}
			}
			
		}
		if(v.getId()==R.id.next){
			if((crct_ans+wrng_ans)<10  && (arr[0]==1 || arr[1]==1 || arr[2]==1 || arr[3]==1)){					
					for(int i=0;i<4;i++)
						arr[i]=0;					
						b1.setTextColor(Color.BLACK);
						b2.setTextColor(Color.BLACK);
						b3.setTextColor(Color.BLACK);
						b4.setTextColor(Color.BLACK);					
					for(int i=0;i<10;i++){						
					  if(s.equals("tec")){
						      if(qn[i]==0){
								c.moveToPosition(i);
								String s=c.getString(0);
								t1.setText(s);
								qn[i]=1;
								if(i==0){
									b1.setText("Image file");
									b2.setText("Animation/movie file");
									b3.setText("Audio file");
									b4.setText("MS Office document");
									ans=c.getString(1);
									break;
								}
								else if(i==1){
									b1.setText("1970s");
									b2.setText("1950s");
									b3.setText("1980s");
									b4.setText("1960s");
									ans=c.getString(1);
									break;
								}
								else if(i==2){
									b1.setText("To decrease the current");
									b2.setText("To increase the current");
									b3.setText("To decrease the voltage momentarily");
									b4.setText("To increase the voltage momentarily");
									ans=c.getString(1);
									break;
								}
								else if(i==3){
									b1.setText("WordPerfect Document file");
									b2.setText("MS Office document");
									b3.setText("Animation/movie file");
									b4.setText("Image file");
									ans=c.getString(1);
									break;
								}
								else if(i==4){
									b1.setText("Dennis Ritchie & Ken Thompson");
									b2.setText("David Filo & Jerry Yang");
									b3.setText("Vint Cerf & Robert Kahn");
									b4.setText("Steve Case & Jeff Bezos");
									ans=c.getString(1);
									break;
								}
								else if(i==5){
									b1.setText("Variant Voltage Vile FrequencyVery");
									b2.setText("Variable Velocity Variable Fun");
									b3.setText("Very Vicious Frequency");
									b4.setText("Variable Voltage Variable Frequency");
									ans=c.getString(1);
									break;
								}
								else if(i==6){
									b1.setText("Programmable Lift Computer");
									b2.setText("Program List Control");
									b3.setText("Programmable Logic Controller");
									b4.setText("Piezo Lamp Connector");
									ans=c.getString(1);
									break;
								}
								else if(i==7){
									b1.setText("Image File");
									b2.setText("System File");
									b3.setText("Hypertext related File");
									b4.setText("None of the above");
									ans=c.getString(1);
									break;
								}
								else if(i==8){
									b1.setText("Phil Zimmermann");
									b2.setText("Tim Berners-Lee");
									b3.setText("Marc Andreessen");
									b4.setText("Ken Thompson");
									ans=c.getString(1);
									break;
								}
								else {
									b1.setText("Jaun Kaum");
									b2.setText("Mark Zukerberg");
									b3.setText("Larry Page");
									b4.setText("Andy Rubin");
									ans=c.getString(1);
									break;
								}
						  }
					  }
					  else if(s.equals("gen")){
						if(qn[i]==0){
							c.moveToPosition(i);
							String s=c.getString(0);
							t1.setText(s);
							qn[i]=1;
							if(i==0){
								b1.setText("Behavior of human beings");
								b2.setText("Insects");
								b3.setText("The formation of rocks");
								b4.setText("None of the above");
								ans=c.getString(1);
								break;
							}
							else if(i==1){
								b1.setText("Junagarh, Gujarat");
								b2.setText("Diphu, Assam");
								b3.setText("Kohima, Nagaland");
								b4.setText("Gangtok, Sikkim");
								ans=c.getString(1);
								break;
							}
							else if(i==2){
								b1.setText("Foreign Finance Corporation");
								b2.setText("Film Finance Corporation");
								b3.setText("Federation of Football Council");
								b4.setText("None of the above");
								ans=c.getString(1);
								break;
							}
							else if(i==3){
								b1.setText("Dr. G. D. Bist");
								b2.setText("J.R.D. Tata");
								b3.setText("Khudada Khan");
								b4.setText("J.M. Tagore	D.");
								ans=c.getString(1);
								break;
							}
							else if(i==4){
								b1.setText("1839");
								b2.setText("1848");
								b3.setText("1843");
								b4.setText("1833");
								ans=c.getString(1);
								break;
							}
							else if(i==5){
								b1.setText("China and Britain");
								b2.setText("China and France");
								b3.setText("China and Egypt");
								b4.setText("China and Greek");
								ans=c.getString(1);
								break;
							}
							else if(i==6){
								b1.setText("New York, USA");
								b2.setText("Haque (Netherlands)");
								b3.setText("Geneva");
								b4.setText("Paris ");
								ans=c.getString(1);
								break;
							}
							else if(i==7){
								b1.setText("Horse racing");
								b2.setText("Polo");
								b3.setText("Snooker");
								b4.setText("Shooting");
								ans=c.getString(1);
								break;
							}
							else if(i==8){
								b1.setText("Muslim president of India");
								b2.setText("vice president of India");
								b3.setText("president of Indian National Congress");
								b4.setText("first speaker of Lok Sabha ");
								ans=c.getString(1);
								break;
							}
							else{
								b1.setText("Earthquakes");
								b2.setText("Rainfall");
								b3.setText("Ocean depth");
								b4.setText("Sound intensity");
								ans=c.getString(1);
								break;
							}
						}
					  }
					  else{
						  if(qn[i]==0){
								c.moveToPosition(i);
								String s=c.getString(0);
								t1.setText(s);
								qn[i]=1;
								if(i==0){
									b1.setText("Dadasaheb Phalke");
									b2.setText("V.Shantaram");
									b3.setText("Ardeshir Irani");
									b4.setText("Kidar Sharma");
									ans=c.getString(1);
									break;
								}
								else if(i==1){
									b1.setText("Sanjeev Kumar");
									b2.setText("Guru Dutt");
									b3.setText("Amitabh Bachchan");
									b4.setText("Dilip Kumar");
									ans=c.getString(1);
									break;
								}
								else if(i==2){
									b1.setText("Raj Kapoor");
									b2.setText("Dilip Kumar");
									b3.setText("Premnath");
									b4.setText("Kishore Kumar");
									ans=c.getString(1);
									break;
								}
								else if(i==3){
									b1.setText("Chiranjeevi");
									b2.setText("Rajinikanth");
									b3.setText("Premnath");
									b4.setText("Nagarjuna");
									ans=c.getString(1);
									break;
								}
								else if(i==4){
									b1.setText("Politics");
									b2.setText("Dance");
									b3.setText("Sports");
									b4.setText("Bollywood");
									ans=c.getString(1);
									break;
								}
								else if(i==5){
									b1.setText("Rab Ne Bana Di Jodi");
									b2.setText("Jab Tak Hai Jaan");
									b3.setText("Veer Zara");
									b4.setText("Ek Tha Tiger");
									ans=c.getString(1);
									break;
								}
								else if(i==6){
									b1.setText("The Guide");
									b2.setText("Mother India");
									b3.setText("Madhumati");
									b4.setText("Amrapali");
									ans=c.getString(1);
									break;
								}
								else if(i==7){
									b1.setText("1952");
									b2.setText("1964");
									b3.setText("1954");
									b4.setText("1960");
									ans=c.getString(1);
									break;
								}
								else if(i==8){
									b1.setText("Bhanu athaiya");
									b2.setText("AR Rahman");
									b3.setText("Rasul Pookutty");
									b4.setText("None of the Above");
									ans=c.getString(1);
									break;
								}
								else {
									b1.setText("1962");
									b2.setText("1965");
									b3.setText("1952");
									b4.setText("1959");
									ans=c.getString(1);
									break;
								}
						
						  	}
					  }				
					}
			}
		  }	
			if((crct_ans+wrng_ans)==10 ){
				t3.setText("Quiz Completed!!");
				t3.setTextColor(Color.GREEN);
				t4.setText("Correct Answers="+crct_ans);
				t4.setTextColor(Color.GREEN);
				t5.setText("Wrong Answers="+wrng_ans);
				t5.setTextColor(Color.RED);
				counter.cancel();
				
			}
		}
		if((crct_ans+wrng_ans)<=10){
			t4.setText("Correct Answers="+crct_ans);		
			t4.setTextColor(Color.GREEN);
			t5.setText("Wrong Answers="+(wrng_ans));
			t5.setTextColor(Color.RED);
		}
		if(v.getId()==R.id.ib){
			AlertDialog.Builder ab=new AlertDialog.Builder(Quiz.this);
			ab.setTitle("Quit Quiz");
			ab.setMessage("Your progress won't be saved!!");
			ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface arg0, int arg1) {
					Intent i=new Intent(Quiz.this,MainActivity.class);
					i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					i.putExtra("EXIT",true);
					startActivity(i);
				}
			});
			ab.setNegativeButton("No",new DialogInterface.OnClickListener() {		
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					arg0.dismiss();
				}
			});
			ab.show();
		}
			
	}
}