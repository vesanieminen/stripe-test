package com.example.application.components;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.littemplate.LitTemplate;

@Tag("stripe-component")
@NpmPackage(value = "@stripe/stripe-js", version = "v1.21.2")
@JsModule("./src/stripe-component.ts")
public class StripeComponent extends LitTemplate {

    public StripeComponent(String publicKey) {
        getElement().setProperty("key", publicKey);
    }

}
