Ext.onReady(function() {

	var navigationPanel = {
		title: '导航',
		layout: 'border',
		region: 'west',
		collapsible: true,
		autoScroll: true,
		border: true,
		split: true,
		margins: '2 0 5 5',
		width: 102,
		minSize: 102,
		maxSize: 202,
		rbar: [
			{
	            text: '注册',
	            textAlign: 'center',
	            handler: function(){Ext.Msg.alert('help','please help me!');}
	        },
	        {
	            text: '登录',
	            textAlign: 'center',
	            handler: function(){
	            	addTab('1', 'hello', 'http://baidu.com', true);
	            }
	        },
	        {
	            text: '顺序练习',
	            textAlign: 'center',
	            handler: function() {
	            	addTab('sequence', '顺序练习', 'test.html#sequence', true);
	            }
	        },
	        {
	            text: '随机练习',
	            textAlign: 'center',
	            handler: function() {
	            	addTab('random', '随机练习', 'test.html#random', true);
	            }
	        }
        ]
	};

	var tabPanel = Ext.createWidget('tabpanel', {
		id: 'tab-panel',
		region: 'center',
        resizeTabs: false,
		margins: '2 5 5 0',
        enableTabScroll: true,
        items: [{
            title: '首页',
            contentEl: 'tab-intro',
            closable: false,
            autoScroll: true,
            bodyPadding: 10
        }]
    });
    
	Ext.create('Ext.Viewport', {
		layout: 'border',
		items: [{
			xtype: 'box',
			id: 'header',
			region: 'north',
			html: '<h1>2013年驾驶员理论考试（科目一）学习资料</h1>',
			height: 50
		}, navigationPanel, tabPanel],
		renderTo: Ext.getBody()
	});
	
	function addTab(id, title, link, closable) {
		id = 'tab-' + id;
		var tab = tabPanel.getComponent(id);
		if(null == tab) {
			link = '' + link;
			title = '' + title;
		    tab = tabPanel.add({
		    	id: id,
		        closable: !! closable,
		        title: title
		    });
		    tabPanel.show();
		}
	    tabPanel.setActiveTab(tab);
	    Ext.get(id + '-body').createChild({
	    	tag: 'iframe',
	    	frameborder: 0,
	    	src: link,
	    	width: Ext.get(id + '-body').getWidth(),
	    	height: Ext.get(id + '-body').getHeight()
	    });
	}
});