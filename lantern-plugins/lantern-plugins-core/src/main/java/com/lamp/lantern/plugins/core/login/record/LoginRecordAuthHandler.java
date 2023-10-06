package com.lamp.lantern.plugins.core.login.record;

import javax.annotation.Resource;

import com.lamp.lantern.plugins.api.mode.LoginRecordInfo;
import com.lamp.lantern.plugins.api.mode.UserInfo;
import com.lamp.lantern.plugins.api.service.LoginRecordService;
import com.lamp.lantern.plugins.core.login.AbstractAuthHandler;

public class LoginRecordAuthHandler extends AbstractAuthHandler<Object> {
	
	@Resource
	private LoginRecordService loginRecordService;
	
	@Override
	public void doAuthAfter(UserInfo userInfo) {
		this.loginRecord("success", userInfo);
	}
	
	@Override
	public void doError(UserInfo userInfo){
		this.loginRecord("fail", userInfo);
	}
	
	private void loginRecord(String type , UserInfo userInfo ) {
		LoginRecordInfo loginRecordInfo = new LoginRecordInfo();
		loginRecordService.insertLoginRecord(loginRecordInfo);
	}
}
