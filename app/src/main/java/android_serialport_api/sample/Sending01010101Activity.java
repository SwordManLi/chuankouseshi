/*
 * Copyright 2011 Cedric Priscal
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */

package android_serialport_api.sample;

import java.io.IOException;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android_serialport_api.sample.R;

public class Sending01010101Activity extends SerialPortActivity {

	SendingThread mSendingThread;

	public byte[] mBuffer;

	@ViewInject(R.id.tv_Electric_Value)
	private TextView tv_Electric_Value;

	@ViewInject(R.id.et00)
	private EditText et00;
	@ViewInject(R.id.et01)
	private EditText et01;
	@ViewInject(R.id.et02)
	private EditText et02;
	@ViewInject(R.id.et03)
	private EditText et03;
	@ViewInject(R.id.et04)
	private EditText et04;
	@ViewInject(R.id.et05)
	private EditText et05;
	@ViewInject(R.id.et06)
	private EditText et06;
	@ViewInject(R.id.et07)
	private EditText et07;
	@ViewInject(R.id.et08)
	private EditText et08;

	public Timer timer = null;//计时器

	public StringBuilder mstringBuilder;

	private int Cyclic_value = 0;

	private int Motor_Cyclic_value = 0;
	private  String motor_id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sending01010101);
		ViewUtils.inject(this);
		 mstringBuilder = new StringBuilder();
		this.mBuffer = new byte[5];
		this.mBuffer[0] = 0x1b;
		this.mBuffer[1] = 0x48;
		this.mBuffer[2] = 0x01;
		this.mBuffer[3] = 0x0d;
		this.mBuffer[4] = 0x0a;
	}
	 @OnClick(R.id.btn00)
	 public void OnClickBtn0(View view){
		  motor_id = et00.getText().toString();
		 if (timer!=null){
			 Toast.makeText(this,"正在进行全货道检测！再等等",Toast.LENGTH_SHORT).show();
		 }else {
			 if (getEditTextString(motor_id)!=100)
			  startShipment(getEditTextString(motor_id));
		 }
	 }

	@OnClick(R.id.btn01)
	 public void OnClickBtn1(View view){
		motor_id = et01.getText().toString();
		if (timer!=null){
			Toast.makeText(this,"正在进行全货道检测！再等等",Toast.LENGTH_SHORT).show();
		}else {
			if (getEditTextString(motor_id)!=100)
				startShipment(getEditTextString(motor_id));
		}
	 }
	 @OnClick(R.id.btn02)
	 public void OnClickBtn2(View view){
		 motor_id = et02.getText().toString();
		 if (timer!=null){
			 Toast.makeText(this,"正在进行全货道检测！再等等",Toast.LENGTH_SHORT).show();
		 }else {
			 if (getEditTextString(motor_id)!=100)
				 startShipment(getEditTextString(motor_id));
		 }
	 }
	 @OnClick(R.id.btn03)
	 public void OnClickBtn3(View view){
		 motor_id = et03.getText().toString();
		 if (timer!=null){
			 Toast.makeText(this,"正在进行全货道检测！再等等",Toast.LENGTH_SHORT).show();
		 }else {
			 if (getEditTextString(motor_id)!=100)
				 startShipment(getEditTextString(motor_id));
		 }
	 }
	 @OnClick(R.id.btn04)
	 public void OnClickBtn4(View view){
		 motor_id = et04.getText().toString();
		 if (timer!=null){
			 Toast.makeText(this,"正在进行全货道检测！再等等",Toast.LENGTH_SHORT).show();
		 }else {
			 if (getEditTextString(motor_id)!=100)
				 startShipment(getEditTextString(motor_id));
		 }
	 }
	 @OnClick(R.id.btn05)
	 public void OnClickBtn5(View view){
		 motor_id = et05.getText().toString();
		 if (timer!=null){
			 Toast.makeText(this,"正在进行全货道检测！再等等",Toast.LENGTH_SHORT).show();
		 }else {
			 if (getEditTextString(motor_id)!=100)
				 startShipment(getEditTextString(motor_id));
		 }
	 }
	 @OnClick(R.id.btn06)
	 public void OnClickBtn6(View view){
		 motor_id = et06.getText().toString();
		 if (timer!=null){
			 Toast.makeText(this,"正在进行全货道检测！再等等",Toast.LENGTH_SHORT).show();
		 }else {
			 if (getEditTextString(motor_id)!=100)
				 startShipment(getEditTextString(motor_id));
		 }
	 }
	 @OnClick(R.id.btn07)
	 public void OnClickBtn7(View view){
		 motor_id = et07.getText().toString();
		 if (timer!=null){
			 Toast.makeText(this,"正在进行全货道检测！再等等",Toast.LENGTH_SHORT).show();
		 }else {
			 if (getEditTextString(motor_id)!=100)
				 startShipment(getEditTextString(motor_id));
		 }
	 }
	 @OnClick(R.id.btn08)
	 public void OnClickBtn8(View view){
		 motor_id = et08.getText().toString();
		 if (timer!=null){
			 Toast.makeText(this,"正在进行全货道检测！再等等",Toast.LENGTH_SHORT).show();
		 }else {
			 if (getEditTextString(motor_id)!=100)
				 startShipment(getEditTextString(motor_id));
		 }
	 }

	@OnClick(R.id.btn_all)
	public void OnClickBtnAll(View view){
		if (timer!=null){
			Toast.makeText(this,"正在进行全货道检测，请不要再做无用功",Toast.LENGTH_SHORT).show();
		}else {
			startTimer();
		}
	}

	@OnClick(R.id.btn_stop)
	public void OnClickBtnStop(View view){
		if (timer!=null){
			timer.cancel();
			timer=null;
			Cyclic_value=0;
			Motor_Cyclic_value=0;
		}else {
			Toast.makeText(this,"未进行全货道检测，不需要停止",Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	protected void onDataReceived(final byte[] buffer, int size) {
		// ignore incoming data
		mstringBuilder.append(bytesToHexString(buffer));
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				tv_Electric_Value.setText(mstringBuilder);
			}
		});
	}

	private class SendingThread extends Thread {
		@Override
		public void run() {
//			while (!isInterrupted()) {
				try {
					if (mOutputStream != null) {
						mOutputStream.write(mBuffer);
					} else {
						return;
					}
				} catch (IOException e) {
					e.printStackTrace();
					return;
				}
//			}
		}
	}
	/**
	 * 数组转换成十六进制字符串
	 *
	 * @param
	 * @return HexString
	 */
	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder();
		String hv = null;
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			stringBuilder.delete(0,stringBuilder.length());
			int v = src[i] & 0xFF;
			 hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	/**
	 * 开启计时器
	 */
	public void startTimer() {
		timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				mHandler.sendEmptyMessage(0x00);
			}
		};
		timer.schedule(timerTask, 0, 1000);  //每隔一秒发送一次
	}


	Handler mHandler = new Handler(){
		/**
		 * @param msg
		 */
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what){
				case 0x00:
					setCyclic_value(Cyclic_value);
//					Log.d("Tag倒计时",Cyclic_value+"电机循环值："+Motor_Cyclic_value);
					Cyclic_value++;
					break;
			}
		}
	};

	/**
	 * 电机循环变化
	 * @param motor_cyclic_value
	 */
	private void setMotorCyclic_value(int motor_cyclic_value) {
		switch (motor_cyclic_value){
			case 9:
				Motor_Cyclic_value=0;
				break;
		}
	}

	/**
	 * 5秒循环值变化
	 * @param cyclicValue
	 */
	public void setCyclic_value(int cyclicValue){
		switch (cyclicValue){
			case 0:
				startShipment(Motor_Cyclic_value);
				break;
			case 6:
				Cyclic_value=0;
				Motor_Cyclic_value++;
				setMotorCyclic_value(Motor_Cyclic_value);
				startShipment(Motor_Cyclic_value);
				break;
		}
	}
	/**
	 * 开始转动
	 * @param Motor_value
	 */
	private void startShipment(int Motor_value) {
		if (mstringBuilder.length() != 0) {
			mstringBuilder.delete(0, mstringBuilder.length());
		}
		mBuffer[2] = (byte) Motor_value;
		mSendingThread = new SendingThread();
		mSendingThread.start();
	}

	/**
	 * 获取编辑框数字
	 * @return
	 */
	private int getEditTextString(String motor_id) {
		if (!NullUtil.isNullorEmpty(motor_id)){
			if (NullUtil.isNumeric(motor_id)){
				return Integer.parseInt(motor_id);
			}else {
				Toast.makeText(this,"输入格式不规范",Toast.LENGTH_SHORT).show();
			}
		}else {
			Toast.makeText(this,"输入框为空",Toast.LENGTH_SHORT).show();
		}
		return 100;
	}
}
