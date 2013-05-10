/**
 * 错题记录
 * 
 * @returns
 */
var record = {
	userCookieName : 'driving-test-user',

	getUser : function() {
		var cookie = Ext.util.Cookies.get(this.userCookieName);
		if (null == cookie || '' == cookie) {
			cookie = '' + parseInt(Math.random() * 2147483647);
			Ext.util.Cookies.set(this.userCookieName, cookie, new Date((new Date()).getTime() + 365
					* 24 * 3600 * 1000));
			return cookie;
		}
		return cookie;
	},

	addWrongQuestion : function(review, id) {
		recordService.addWrongQuestion(this.getUser(), review, id);
	},

	getWrongQuestion : function(review, callback) {
		recordService.getWrongQuestion(this.getUser(), review, function(data) {
			callback(data);
		});
	},

	removeWrongQuestion : function(review, id, callback) {
		recordService.removeWrongQuestion(this.getUser(), review, id, function(data) {
			callback(data);
		});
	}
};

var messageBox = function(title, msg, target) {
	if (target) {
		Ext.MessageBox.show({
			title : title,
			msg : msg,
			width : 400,
			closable : true,
			buttons : Ext.MessageBox.OK,
			icon : Ext.MessageBox.INFO,
			animateTarget : target
		});
		setTimeout(function() {
			Ext.MessageBox.hide();
		}, 1200);
	} else {
		Ext.MessageBox.show({
			title : title,
			msg : msg,
			width : 400,
			closable : false,
			icon : Ext.MessageBox.INFO
		});
	}
};