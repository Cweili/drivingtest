Ext.onReady(function() {
	var question = null;
	var ids = new Array();
	var rate = 1;
	var maxRate = 1;
	var minRate = 1;
	var loading = true;
	var autoNext = true;
	
	var viewport = null;
	var buttonPrev = null;
	var buttonNext = null;
	var textRate = null;
	var checkboxAutoNext = null;
	var questionToolbarRight = null;
	var questionContent = null;
	var questionOption = null;
	var questionToolbar = null;
	var questionImage = null;
	var questionDetail = null;
	
	var buttonWidth = 150;
	var buttonHeight = 50;
	
	questionService.getQuestionIdList(window.location.hash, function(data){
		ids = Ext.decode(data);
		maxRate = ids.length;
		if (maxRate > 0) {
			initComponent();
			update();
		} else {
			messageBox('暂时没有题目哦', '暂时没有题目哦，请等待管理员添加吧！');
		}
	});
	
	var initComponent = function() {
		buttonPrev = {
			xtype: 'button',
			margins: '0 5 0 5',
			width: buttonWidth,
			height: buttonHeight,
			handler: function() {
				rate--;
				update();
			},
			html: '上一题'
		};
		
		buttonNext = {
			xtype: 'button',
			margins: '0 5 0 5',
			width: buttonWidth,
			height: buttonHeight,
			handler: function() {
				rate++;
				update();
			},
			html: '下一题'
		};
		
		textRate = new Ext.form.field.Number({
			inputId: 'text-rate',
			name: 'number',
			value: rate,
			maxValue: maxRate,
			minValue: minRate,
			listeners: {
				change: function(field, newValue) {
					rate = parseInt(newValue);
					update();
				}
			}
		});
		
		checkboxAutoNext = {
			xtype: 'checkboxgroup',
			columns: [150],
			items: [
				{
					boxLabel: '回答正确自动下一题',
					checked: true,
					handler: function() {
						autoNext = !autoNext;
					}
				}
			]
		};
		
		questionToolbarRight = {
			xtype: 'panel',
			border: false,
			layout: {
				type: 'vbox',
				align: 'center'
			},
			items: [
				{
					xtype: 'label',
					text: '共 ' + maxRate + ' 题，目前进度',
					margin: '0 10 0 10'
				},
				checkboxAutoNext
			]
		};
		
		questionContent = {
			xtype: 'panel',
			id: 'question-content',
			region: 'north',
			border: false,
			height: 100
		};
		
		questionOption = {
			xtype: 'panel',
			id: 'question-option',
			region: 'west',
			border: false,
			margin: '5 0 0 0',
			width: 400
		};
		
		questionToolbar = {
			xtype: 'panel',
			id: 'question-toolbar',
			region: 'south',
			border: false,
			margin: '2 0 0 6',
			height: 64,
			layout: {
				type: 'hbox',
				align: 'center'
			},
			items: [ buttonPrev, buttonNext, questionToolbarRight, textRate ]
		};
		
		questionImage = {
			xtype: 'panel',
			id: 'question-image',
			region: 'center',
			border: false
		};
		
		questionDetail = {
			xtype: 'panel',
			id: 'question-detail',
			region: 'east',
			border: false,
			width: 120,
		};
		
		viewport = Ext.create('Ext.Viewport', {
			layout: 'border',
			items: [
				questionContent, questionOption, questionDetail,
				questionToolbar, questionImage
			],
			renderTo: Ext.getBody()
		});
	};
	
	var answer = function(answerId) {
		if ('answer-' + question.answer == answerId) {
			messageBox('恭喜回答正确', '恭喜回答正确', 'question-image');
			if (autoNext) {
				rate++;
				update();
			}
		} else {
			messageBox('抱歉回答错误', '正确答案是：<strong>' + question.option[question.answer] + '</strong>', 'question-image');
			record.addWrongQuestion(question.id);
		}
	};
	
	var update = function() {
		setLoadingStatus();
		
		rate = rate > minRate ? rate : minRate;
		rate = rate < maxRate ? rate : maxRate;
		
		questionService.getQuestion(ids[rate - 1], function(data) {
			question = Ext.decode(data);
			if (0 == question.type || 2 == question.type) {
				question.content = '选择题：' + question.content;
			} else {
				question.content = '判断题：' + question.content;
			}
			Ext.get('question-content').setHTML(question.content);
			Ext.get('question-detail').setHTML(
				'<h4>题目分类</h4>' + question.category
				+ '<h4>出题概率</h4>' + question.frequency
			);
			textRate.setValue(rate);
			updateOption();
			updateImage();
			setLoadingStatus();
		});	
	};
	
	var updateOption = function() {
		Ext.get('question-option').setHTML('');
		var buttons = new Array(question.option.length);
		for (var i = 0; i < question.option.length; i++) {
			buttons[i] = {
				xtype: 'button',
				id: 'answer-' + i,
				margins: '5 0 0 0',
				width: 390,
				height: buttonHeight,
				html: question.option[i],
				handler: function() {
					answer(this.id);
				}
			};
		}
		Ext.create('Ext.Panel', {
			layout: {
				type: 'vbox',
				align: 'center'
			},
			border: false,
			items: buttons,
			renderTo: 'question-option'
		});
	};
	
	var updateImage = function() {
		Ext.get('question-image').setHTML('');
		Ext.get('question-image').createChild({
			tag: 'img',
			id: 'question-image-img',
			height: 0
		});
		if (2 == question.type || 3== question.type) {
			imageService.getImage(question.id, function(data){
				Ext.get('question-image-img').set({
					height: 320,
					src: 'data:image/jpeg;base64,' + data
				});
			});
		}
	};
	
	var setLoadingStatus = function() {
		if (true == loading) {
			viewport.setLoading({
				msg: 'Loading...',
				useTargetEl: true
			});
			loading = false;
		} else {
			viewport.setLoading(false);
			loading = true;
		}
	};

});