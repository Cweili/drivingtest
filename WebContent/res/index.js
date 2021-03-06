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
				text: '顺序练习',
				textAlign: 'center',
				handler: function() {
					addTab('test-sequence', '顺序练习', 'test.html#sequence', true);
				}
			},
			{
				text: '随机练习',
				textAlign: 'center',
				handler: function() {
					addTab('test-random', '随机练习', 'test.html#random', true);
				}
			},
			{
				text: '一轮复习',
				textAlign: 'center',
				handler: function() {
					addTab('revie-wonce', '一轮复习', 'review.html#once', true);
				}
			},
			{
				text: '二轮复习',
				textAlign: 'center',
				handler: function() {
					addTab('revie-wtwice', '二轮复习', 'review.html#twice', true);
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
	
	var addTab = function(id, title, link, closable) {
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
	};
});