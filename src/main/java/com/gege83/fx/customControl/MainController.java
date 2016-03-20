package com.gege83.fx.customControl;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

@Component
public class MainController implements Initializable {

	private final SomeService service;

	@Autowired
	public MainController(SomeService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO something
	}

	@FXML
	public void doSomeThing(ActionEvent event) {
		System.out.println("event fired");
		service.doSomeThing();
	}

}
