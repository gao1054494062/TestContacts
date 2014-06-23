package com.example.appadmination.test;


import java.util.ArrayList;

import com.robotium.solo.Solo;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.TextView;
@SuppressWarnings("rawtypes")
public class TestMain extends ActivityInstrumentationTestCase2 
{

	private static final String ACTIVITY_NAME = "com.android.contacts.activities.PeopleActivity";
	@SuppressWarnings("rawtypes")
	private static Class ActivityClass;
	static
	{
		try
		{
			ActivityClass = Class.forName(ACTIVITY_NAME);
		}catch(ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
	}
	@SuppressWarnings("unchecked")
	public TestMain() {
		super(ActivityClass);
	}
	
	private Solo solo;
	protected void setUp() throws Exception
	{
		solo = new Solo(getInstrumentation(),getActivity());
	}
	
//	//删除联系人aaa
//	public void testDeleteName()
//	{
//		String search = "abc";
//		while(solo.searchText(search))
//		{
//			solo.clickOnText(search);
//			solo.sendKey(KeyEvent.KEYCODE_MENU);
//			solo.clickOnText("删除");
////				solo.clickOnMenuItem("删除");
//			solo.clickOnButton("确定");
//		}
//		assertEquals(solo.searchText(search),false);
//	}
		
		
	//删除联系人aaa
	public void DeleteName(String search)
	{
		while(solo.searchText(search))
		{
			solo.clickOnText(search);
			solo.sleep(1000);
			solo.sendKey(KeyEvent.KEYCODE_MENU);
			solo.clickOnText("删除");
			solo.clickOnButton("确定");
		}
		assertEquals(solo.searchText(search),false);
	}
	//拨号
	public void ClickNumber(String num)
	{
		
		for(int i=0; i<num.length(); i++)
		{
			switch(num.charAt(i))
			{
			case '0':
				solo.clickOnView(solo.getView("com.android.contacts:id/zero"));
				break;
			case '1':
				solo.clickOnView(solo.getView("com.android.contacts:id/one"));
				break;
			case '2':
				solo.clickOnView(solo.getView("com.android.contacts:id/two"));
				break;
			case '3':
				solo.clickOnView(solo.getView("com.android.contacts:id/three"));
				break;
			case '4':
				solo.clickOnView(solo.getView("com.android.contacts:id/four"));
				break;
			case '5':
				solo.clickOnView(solo.getView("com.android.contacts:id/five"));
				break;
			case '6':
				solo.clickOnView(solo.getView("com.android.contacts:id/six"));
				break;
			case '7':
				solo.clickOnView(solo.getView("com.android.contacts:id/seven"));
				break;
			case '8':
				solo.clickOnView(solo.getView("com.android.contacts:id/eight"));
				break;
			case '9':
				solo.clickOnView(solo.getView("com.android.contacts:id/nine"));
				break;
			default:
				break;
			}
		}
	}
		
	//新建联系人gao
	public void testCT001()
	{
		//显示本地号码
		solo.sendKey(KeyEvent.KEYCODE_MENU);
		solo.clickInList(1);
		if(!solo.isCheckBoxChecked(1))
		{
			solo.clickOnCheckBox(1);
		}
		if(solo.isCheckBoxChecked(0))
		{
			solo.clickOnCheckBox(0);
		}
		solo.clickOnButton("确定");
		solo.sleep(1000);
		
		//删除联系人gao
		String newContact = "gao";
		DeleteName(newContact);
		
		//新建按钮
		ImageButton add = (ImageButton) solo.getView("com.android.contacts:id/btn_add_contact");
		solo.clickOnView(add);
		solo.goBack();

		for(int i=0;i<2;i++)
		{
			solo.scrollToBottom();
			solo.clickOnText("添加更多项");
			solo.clickInList(1);
			solo.sleep(1000);
		}
		//输入更多
		solo.sleep(1000);
		solo.scrollToTop();
		solo.enterText(0, newContact);
		solo.enterText(1, newContact);
		solo.enterText(2, "ztemt");
		solo.enterText(3, "software");
		
		//输入电话
		solo.pressSpinnerItem(0, 1);
		solo.enterText(solo.getEditText("电话"), "123");
		//输入Email
		solo.pressSpinnerItem(2, 0);
		solo.enterText(solo.getEditText("电子邮件"), "1054494062@qq.com");
		//输入即时消息
		solo.pressSpinnerItem(4, 0);
		solo.enterText(solo.getEditText("即时消息"), "1054494062");
//		//输入地址
//		solo.pressSpinnerItem(6, 0);
//		solo.enterText(solo.getEditText("地址"), "南山区科技园");
//		//输入备注、昵称、网站
//		solo.enterText(solo.getEditText("备注"), "备注");
//		solo.enterText(solo.getEditText("昵称"), "昵称");
//		solo.enterText(solo.getEditText("网站"), "www.nubia.com");
//		//输入纪念日
//		solo.pressSpinnerItem(0, 0);
//		solo.clickOnText("日期");
//		solo.clickOnText("确定");

		TextView save = (TextView) solo.getView("com.android.contacts:id/mSave");
		solo.clickOnView(save);
//		solo.clickOnText("完成");
		
		solo.clickOnText(newContact);
		solo.clickOnText("编辑");
		
		assertEquals(solo.getText(0).getText().toString(),newContact);
		assertEquals(solo.getText(1).getText().toString(),newContact);
		assertEquals(solo.getText(2).getText().toString(),"ztemt");
		assertEquals(solo.getText(3).getText().toString(),"software");
		assertEquals(solo.getText(6).getText().toString(),"123");
//		assertEquals(solo.getText(10).getText().toString(),"1054494062@qq.com");
//		assertEquals(solo.getText(14).getText().toString(),"1054494062");
		
//		solo.scrollListToLine(absListView, line);
//		solo.scrollDown();
//		solo.scrollToBottom();
//		assertEquals(solo.getText(1).getText().toString(),"备注");
//		assertEquals(solo.getText(3).getText().toString(),"昵称");
//		assertEquals(solo.getText(5).getText().toString(),"www.nubia.com");
	}
		
	//002新建联系人并取消
	public void testCT002()
	{
		//显示本地号码
		solo.sendKey(KeyEvent.KEYCODE_MENU);
		solo.clickInList(1);
		if(solo.isCheckBoxChecked(0))
		{
			solo.clickOnCheckBox(0);
		}
		if(!solo.isCheckBoxChecked(1))
		{
			solo.clickOnCheckBox(1);
		}
		solo.clickOnButton("确定");
		solo.sleep(2000);
		
		//统计listview的元素数目
		ListView contact_list = (ListView) solo.getView("android:id/list",0);
		int contact_num1 = contact_list.getAdapter().getCount();
		Log.i("TestRunner", "contact_num1="+String.valueOf(contact_num1));
		
		//设置默认位置为本机
		solo.sendKey(KeyEvent.KEYCODE_MENU);
		solo.clickInList(4);
		solo.clickInList(2);
		ListView list = (ListView) solo.getView("android:id/select_dialog_listview");
		solo.clickOnView(list.getChildAt(1));
		solo.goBack();
		
		//新建联系人
		ImageButton add = (ImageButton) solo.getView("com.android.contacts:id/btn_add_contact");
		solo.clickOnView(add);
		solo.sleep(1000);
		solo.scrollToTop();
		solo.enterText(0, "name");
		solo.enterText(1, "中兴移动");
		solo.enterText(2, "software");

		//输入电话
		solo.pressSpinnerItem(0, 1);
		solo.enterText(solo.getEditText("电话"), "1234569");
		
		solo.goBack();
		solo.clickOnButton("确定");
		solo.sleep(1000);
		
		contact_list = (ListView) solo.getView("android:id/list",0);
		int contact_num2 = contact_list.getAdapter().getCount();
		Log.i("TestRunner", "contact_num2="+String.valueOf(contact_num2));
		
		assertEquals(contact_num1, contact_num2);
	}

	//003新建联系人并完成abc
 	public void testCT003()
	{
 		//显示本地号码
		solo.sendKey(KeyEvent.KEYCODE_MENU);
		solo.clickInList(1);
		if(!solo.isCheckBoxChecked(1))
		{
			solo.clickOnCheckBox(1);
		}
		if(solo.isCheckBoxChecked(0))
		{
			solo.clickOnCheckBox(0);
		}
		solo.clickOnButton("确定");
		solo.sleep(1000);

		String newContact = "abc";
		DeleteName(newContact);
		
		//统计元素数目
		ListView contact_list = (ListView) solo.getView("android:id/list",0);
		int contact_num1 = contact_list.getAdapter().getCount();
		Log.i("TestRunner", String.valueOf(contact_num1));
		
		//设置默认存储位置
		solo.sendKey(KeyEvent.KEYCODE_MENU);
		solo.clickInList(4);
		solo.clickInList(2);
		ListView list = (ListView) solo.getView("android:id/select_dialog_listview");
		solo.clickOnView(list.getChildAt(1));
		solo.goBack();
		
		//新建联系人
		ImageButton add = (ImageButton) solo.getView("com.android.contacts:id/btn_add_contact");
		solo.clickOnView(add);
		solo.sleep(1000);
		solo.scrollToTop();
		solo.enterText(0, newContact);
		solo.enterText(1, "ztemt");
		solo.enterText(2, "software");

		//输入电话和email
		solo.pressSpinnerItem(0, 1);
		solo.enterText(solo.getEditText("电话"), "1234569");
		solo.enterText(solo.getEditText("电话"), "12345");
		solo.pressSpinnerItem(1, 1);
		solo.enterText(solo.getEditText("电子邮件"), "1234569@163.com");
		//保存
		TextView save = (TextView) solo.getView("com.android.contacts:id/mSave");
		solo.clickOnView(save);
		solo.sleep(2000);

		//验证
		int contact_num2 = contact_list.getAdapter().getCount();//添加后元素数目
		Log.i("TestRunner", String.valueOf(contact_num2));
		assertEquals(contact_num2-contact_num1,1);//相差为1，则说明成功添加了一个联系人		
	}
	
 	//004电话卡新建联系人phone
 	public void testCT004()
 	{
		//显示电话卡信息
		solo.sendKey(KeyEvent.KEYCODE_MENU);
		solo.clickInList(1);
		if(!solo.isCheckBoxChecked(0))
		{
			solo.clickOnCheckBox(0);
		}
		if(solo.isCheckBoxChecked(1))
		{
			solo.clickOnCheckBox(1);
		}
		solo.clickOnButton("确定");
		solo.sleep(1000);
		
 		String newContact = "phone";
		DeleteName(newContact);
		 				
 		//统计元素数目
		ListView contact_list = (ListView) solo.getView("android:id/list",0);
		int contact_num1 = contact_list.getAdapter().getCount();
		Log.i("TestRunner", String.valueOf(contact_num1));
		
		
		//设置默认位置
		solo.sendKey(KeyEvent.KEYCODE_MENU);
		solo.clickInList(4);
		solo.clickInList(2);
		ListView list = (ListView) solo.getView("android:id/select_dialog_listview");
		solo.clickOnView(list.getChildAt(0));
		solo.goBack();
		
		//新建联系人
		ImageButton add = (ImageButton) solo.getView("com.android.contacts:id/btn_add_contact");
		solo.clickOnView(add);
		solo.enterText(0, newContact);
		solo.enterText(1, "123545");
		
		TextView save = (TextView) solo.getView("com.android.contacts:id/mSave");
		solo.clickOnView(save);
		solo.sleep(2000);

		int contact_num2 = contact_list.getAdapter().getCount();//添加后元素数目
		Log.i("TestRunner", String.valueOf(contact_num2));
		
		assertEquals(contact_num2-contact_num1,1);//相差为1，则说明成功添加了一个联系人	
 	}
 	
	//005拨号盘存储联系人aaa
	public void testCT005()
	{
		String name = "aaa";
		String company = "ztemt";
		String title = "software";
		
		//显示电话卡信息
		solo.sendKey(KeyEvent.KEYCODE_MENU);
		solo.clickInList(1);
		if(!solo.isCheckBoxChecked(1))
		{
			solo.clickOnCheckBox(1);
		}
		if(solo.isCheckBoxChecked(0))
		{
			solo.clickOnCheckBox(0);
		}
		solo.clickOnButton("确定");
		solo.sleep(1000);
		
		//设置默认存储位置
		solo.sendKey(KeyEvent.KEYCODE_MENU);
		solo.clickInList(4);
		solo.clickInList(2);
		ListView list = (ListView) solo.getView("android:id/select_dialog_listview");
		solo.clickOnView(list.getChildAt(1));
		solo.goBack();

		//删除旧的name
		DeleteName(name);
		
		//拨号
		solo.scrollToSide(Solo.LEFT);
		solo.sleep(1000);
		ImageButton key = (ImageButton) solo.getView("com.android.contacts:id/key_more");
		solo.clickOnView(key);
		String search = "清除通话记录";
		if(solo.searchText(search)){
			solo.clickOnText(search);
			Button btn = (Button) solo.getView("android:id/button1");
			solo.clickOnView(btn);
		}
		else{
			solo.goBack();
		}
		
		String num = "135152";
		solo.sleep(1000);
		ClickNumber(num);
		
		//新建联系人
		solo.clickOnText("新建联系人");
		solo.sleep(1000);
		solo.scrollToTop();
		solo.enterText(0, name);
		solo.enterText(1, company);
		solo.enterText(2, title);
		solo.clickOnText("完成");
		solo.sleep(1000);
		
		//验证
		solo.scrollToSide(Solo.RIGHT);
		solo.clickOnText(name);
		solo.clickOnText("编辑");
		
		assertEquals(solo.getText(0).getText().toString(),name);
		assertEquals(solo.getText(1).getText().toString(),company);
		assertEquals(solo.getText(2).getText().toString(),title);
		assertEquals(solo.getText(5).getText().toString(),num);
	}
	
	//008修改联系人
	public void testCT008()
	{
		String name = "abc";
		solo.clickOnText(name);
		solo.clickOnText("编辑");
		solo.clearEditText(solo.getEditText("ztemt"));
		solo.enterText(1, "zte");
		solo.clearEditText(solo.getEditText("software"));
		solo.enterText(2, "hardware");
		solo.clickOnText("完成");
		solo.goBack();
		
		solo.clickOnText("abc");
		solo.clickOnText("编辑");
		assertEquals(solo.getText(0).getText().toString(),name);
		assertEquals(solo.getText(1).getText().toString(),"zte");
		assertEquals(solo.getText(2).getText().toString(),"hardware");
		
		solo.sleep(1000);
	}
	
	/*//009a添加机主信息等
	public void testCT009a()
	{
		solo.clickOnText("机主信息");
		
		solo.enterText(0, "高");
		solo.enterText(1, "ztemt");
		solo.enterText(2, "software");
		
		//输入电话
		solo.pressSpinnerItem(0, 1);
		solo.enterText(solo.getEditText("电话"), "121564656");
		solo.clickOnText("完成");
		solo.sleep(2000);
		
		solo.clickOnText("高");
		solo.clickOnText("编辑");
		assertEquals(solo.getText(0).getText().toString(),"高");
		assertEquals(solo.getText(1).getText().toString(),"ztemt");
		assertEquals(solo.getText(2).getText().toString(),"software");
		assertEquals(solo.getText(5).getText().toString(),"121564656");
	}*/
	
	/*//009b搜索联系人
	public void testCT009()
	{
		TextView searchText = (TextView)solo.getView("com.android.contacts:id/txtSearch");
		solo.clickOnView(searchText);
		EditText searchEdit = (EditText)solo.getView("android:id/search_src_text");
		solo.enterText(searchEdit, "gao");
		
		solo.sleep(2000);
	}*/
		
 	//012a联系认设置
	public void testCT012a()
	{
		for(int i=0; i<2; i++)
		{
			//统计元素数目
			int flag=0;
			ListView contact_list = (ListView) solo.getView("android:id/list",0);
			int contact_num1 = contact_list.getAdapter().getCount();
			Log.i("TestRunner", String.valueOf(contact_num1));
			
			//显示号码
			solo.sendKey(KeyEvent.KEYCODE_MENU);
			solo.clickInList(1);
			solo.clickOnCheckBox(i);
			
			TextView contact_count = (TextView) solo.getView("com.android.contacts:id/contacts_count",i);
			String display_str = contact_count.getText().toString();
			int display_num = Integer.parseInt(display_str);
			Log.i("TestRunner", String.valueOf(display_num));
			solo.clickOnButton("确定");
			solo.sleep(1000);
			
			//统计元素数目
			int contact_num2 = contact_list.getAdapter().getCount();
			Log.i("TestRunner", String.valueOf(contact_num2));
			
			if(contact_num1==5 || contact_num2==5)
			{
				flag=1;
			}
			assertEquals(display_num, Math.abs(contact_num1-contact_num2)-flag);
			solo.sleep(1000);
		}
	}
	
//	//012b合并联系人
//	public void testCT012b()
//	{
//		//显示本地号码
//		solo.sendKey(KeyEvent.KEYCODE_MENU);
//		solo.clickInList(1);
//		if(!solo.isCheckBoxChecked(1))
//		{
//			solo.clickOnCheckBox(1);
//		}
//		if(!solo.isCheckBoxChecked(0))
//		{
//			solo.clickOnCheckBox(0);
//		}
//		solo.clickOnButton("确定");
//		
//		solo.sendKey(KeyEvent.KEYCODE_MENU);
//		solo.clickInList(4);
//		solo.clickInList(3);
//		solo.clickOnButton("确定");
//		
//		TextView all_repeat= (TextView) solo.getView("com.android.contacts:id/tab_all_repeat");
//		String all_str = all_repeat.getText().toString();
//		if(all_str.length()>4)
//		{
//			Button merge = (Button) solo.getView("com.android.contacts:id/merge_contact_button");
//			solo.clickOnView(merge);
//			solo.clickOnButton("确定");
//		}
//		
//		solo.scrollToSide(Solo.RIGHT);
//		
//		TextView part_repeat= (TextView) solo.getView("com.android.contacts:id/tab_part_repeat");
//		String part_str = part_repeat.getText().toString();
//		if(part_str.length()>4)
//		{
//			Button merge = (Button) solo.getView("com.android.contacts:id/merge_contact_button",1);
//			solo.clickOnView(merge);
//			solo.clickOnButton("确定");
//		}
//		
//		solo.goBack();
//		solo.clickInList(3);
//		solo.clickOnButton("确定");
//		
//		part_repeat= (TextView) solo.getView("com.android.contacts:id/tab_part_repeat");
//		part_str = part_repeat.getText().toString();
//		all_repeat= (TextView) solo.getView("com.android.contacts:id/tab_all_repeat");
//		all_str = all_repeat.getText().toString();
//		assertEquals(part_str.length(),4);
//		assertEquals(all_str.length(),4);
//		solo.sleep(5000);
//	}
	
	//013a拨号盘发短信
	public void testCT013a()
	{
		solo.scrollToSide(Solo.LEFT);
		solo.sleep(1000);
		
		String num = "13515212";
		ClickNumber(num);
		solo.clickOnText("发送信息");
		
//		//获取电话号码信息
//		assertTrue(solo.searchText(num));
//		MultiAutoCompleteTextView phone = (MultiAutoCompleteTextView) 
//				solo.getView("com.android.contacts:id/recipients_editor");
//		solo.clickOnView(phone);
//		String phoneStr = phone.getText().toString();
//		assertEquals(phoneStr, "135152");
		
		Log.i("TestRunner", "123");
		Activity curActivity = solo.getCurrentActivity();
		Log.i("TestRunner", curActivity.toString());
		Log.i("TestRunner", "123");
		
		//查找三个按钮
		EditText embedded = (EditText) 
				solo.getView("com.android.contacts:id/embedded_text_editor");
		solo.enterText(embedded, "新建信息");
		solo.sleep(2000);
		ImageButton insert = (ImageButton) 
				solo.getView("com.android.contacts:id/insert_attachment");
		solo.clickOnView(insert);
		solo.clickOnView(insert);
		ImageButton send = (ImageButton) 
				solo.getView("com.android.contacts:id/send_message");
		solo.clickOnView(send);
		
		solo.sleep(2000);
	}
	
	//013拨号盘打电话
	public void testCT013b()
	{
		solo.scrollToSide(Solo.LEFT);
		
		solo.sleep(1000);
		String num = "135152";
		ClickNumber(num);
		
		ImageButton phone = (ImageButton) solo.getView("com.android.contacts:id/dial_button");
		solo.clickOnView(phone);
		solo.goBack();
	}
	
	//014新建群组
	public void testCT014()
	{
		//显示号码
		solo.sendKey(KeyEvent.KEYCODE_MENU);
		solo.clickInList(1);
		if(!solo.isCheckBoxChecked(1))
		{
			solo.clickOnCheckBox(1);
		}
		if(!solo.isCheckBoxChecked(0))
		{
			solo.clickOnCheckBox(0);
		}
		solo.clickOnButton("确定");
		solo.sleep(1000);
		
		String newGroup = "Group1";
		ImageButton group = (ImageButton) solo.getView("com.android.contacts:id/btn_group");
		solo.clickOnView(group);
		
		//删除旧的信息
		while(solo.searchText(newGroup))		{
			solo.clickOnText(newGroup);
			solo.clickOnText("解散");
			solo.clickOnText("确定");
		}
		
		//新建群组
		TextView add_group = (TextView) solo.getView("com.android.contacts:id/menu_add_group");
		solo.clickOnView(add_group);
		
		//新建群组信息
		EditText group_name = (EditText) solo.getView("com.android.contacts:id/group_name");
		solo.enterText(group_name, newGroup);
		
//		//添加群组方式1
//		EditText add_member = (EditText) solo.getView("com.android.contacts:id/add_member_field");
//		solo.clickOnView(add_member);
//		solo.sendKey(KeyEvent.KEYCODE_A);
//		if(solo.searchText("abc")){
//			solo.clickOnText("abc");
//		}
//		else{
//			solo.clearEditText(add_member);
//		}
//		solo.sendKey(KeyEvent.KEYCODE_G);
//		solo.sendKey(KeyEvent.KEYCODE_A);
//		solo.sendKey(KeyEvent.KEYCODE_O);
//		if(solo.searchText("gao")){
//			solo.clickOnText("gao");
//		}
//		else{
//			solo.clearEditText(add_member);
//		}
		
		//添加群组成员方式2
		ImageButton add_member = (ImageButton) solo.getView("com.android.contacts:id/add_members");
		solo.clickOnView(add_member);
		solo.clickOnText("abc");
		solo.clickOnText("gao");
		Button btn_ok = (Button) solo.getView("com.android.contacts:id/btn_ok");
		solo.clickOnView(btn_ok);
		
		solo.clickOnText("完成");
		
		solo.clickOnText("abc");
		solo.sleep(1000);
		solo.goBack();
		solo.clickOnText("gao");
		solo.sleep(1000);
		solo.goBack();
		
		solo.sleep(1000);
	}
		
	//查看、修改群组信息
	public void testCT015()
	{
		//显示号码
		solo.sendKey(KeyEvent.KEYCODE_MENU);
		solo.clickInList(1);
		if(!solo.isCheckBoxChecked(1))
		{
			solo.clickOnCheckBox(1);
		}
		if(!solo.isCheckBoxChecked(0))
		{
			solo.clickOnCheckBox(0);
		}
		solo.clickOnButton("确定");
		solo.sleep(1000);
		
		//查看
		ImageButton group = (ImageButton) solo.getView("com.android.contacts:id/btn_group");
		solo.clickOnView(group);
		
		ExpandableListView elist = (ExpandableListView) solo.getView("com.android.contacts:id/list");
		TextView label = (TextView) solo.getView("com.android.contacts:id/label",0);
		String lableStr = label.getText().toString();
		Log.i("TestRunner", lableStr);
		
		TextView count = (TextView) solo.getView("com.android.contacts:id/count",0);
		String countStr = count.getText().toString();
		Log.i("TestRunner", countStr);
		int countNum = Integer.parseInt(countStr.substring(0,1));
		
		solo.clickOnView(elist.getChildAt(1));

		ListView list = (ListView) solo.getView("android:id/list");
		int exceptNum = list.getAdapter().getCount();
		assertEquals(countNum, exceptNum);
		
		TextView Group1 = (TextView) solo.getView("android:id/action_bar_title");
		assertEquals(Group1.getText().toString(),lableStr);
		assertTrue(solo.searchText("abc"));
		assertTrue(solo.searchText("gao"));
		
		//修改
		solo.clickOnText("编辑");
		assertTrue(solo.searchText("编辑群组"));
		
		//添加群组方式2
		ImageButton add_member = (ImageButton) solo.getView("com.android.contacts:id/add_members");
		solo.clickOnView(add_member);
		if(solo.searchText("aaa"))
		{
			solo.clickOnText("aaa");
			Button btn_ok = (Button) solo.getView("com.android.contacts:id/btn_ok");
			solo.clickOnView(btn_ok);
			solo.clickOnText("完成");
			
			list = (ListView) solo.getView("android:id/list");
			int addNum  = list.getAdapter().getCount();
			assertEquals(addNum, countNum+1);
			Log.i("TestRunner", addNum+"");
			Log.i("TestRunner", countNum+"");
		}
		
		//删除群组成员
		solo.clickOnText("编辑");
		ImageView delete_button = (ImageView) solo.getView("com.android.contacts:id/delete_button",1);
		solo.clickOnView(delete_button);
		solo.clickOnText("完成");
		solo.sleep(2000);
		
		list = (ListView) solo.getView("android:id/list");
		int deleteNum  = list.getAdapter().getCount();
		assertEquals(deleteNum, countNum);
	}
}