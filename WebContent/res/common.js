var record = new Record();

/**
 * 错题记录
 * 
 * @returns
 */
function Record() {
	this.userCookieName = 'driving-test-user';
	
	this.getUser = function() {
		var cookie = Ext.util.Cookies.get(this.userCookieName);
		if (null == cookie || '' == cookie) {
			cookie = '' + parseInt(Math.random() * 10000000000);
			Ext.util.Cookies.set(this.userCookieName, cookie, new Date((new Date()).getTime() + 365 * 24 * 3600 * 1000));
			return cookie;
		}
		return cookie;
	};
	
	this.addWrongQuestion = function(id) {
		recordService.addWrongQuestion(this.getUser(), id);
	};
	
	this.getWrongQuestion = function(callback) {
		recordService.getWrongQuestion(this.getUser(), function(data) {
			callback(data);
		});
	};
	
	this.removeWrongQuestion = function(id, callback) {
		recordService.removeWrongQuestion(this.getUser(), id, function(data) {
			callback(data);
		});
	};
};

var messageBox = function(title, msg, target) {
	if (target) {
		Ext.MessageBox.show({  
			title: title,
			msg: msg,
			width: 400,
			closable: true,
			buttons: Ext.MessageBox.OK,
			icon: Ext.MessageBox.INFO,
			animateTarget: target 
		});
		setTimeout(function() {
			Ext.MessageBox.hide();
		}, 1200);
	} else {
		Ext.MessageBox.show({  
			title: title,  
			msg: msg,  
			width: 400, 
			closable: false,  
			icon: Ext.MessageBox.INFO
		});
	}
};