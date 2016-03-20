package com.gege83.fx.customControl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

@Component
public class MyCustomControl extends HBox {

	private final SomeService service;
	private final ObjectProperty<EventHandler<ActionEvent>> onClickMeHandler = new SimpleObjectProperty<>();

	@FXML
	protected void doClickMe(ActionEvent event) {
		service.doSomeThing();
		onClickMeHandler.get().handle(event);
	}

	@Autowired
	public MyCustomControl(SomeService service, ApplicationContext applicationContext) {
		this.service = service;
		try {
			final FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setRoot(this);
			fxmlLoader.setController(this);
			fxmlLoader.load(getClass().getResourceAsStream("MyCustomControl.fxml"));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	//
	public EventHandler<ActionEvent> getOnClickMe() {
		return onClickMeHandler.get();
	}

	public void setOnClickMe(EventHandler<ActionEvent> onClickMe) {
		this.onClickMeHandler.set(onClickMe);
	}

	public ObjectProperty<EventHandler<ActionEvent>> onClickMeProperty() {
		return onClickMeHandler;
	}
}
