package com.example.application.views.root;

import com.example.application.components.StripeComponent;
import com.example.application.service.StripeService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("root")
@Route(value = "")
@JsModule("./src/auto-change-theme.js")
public class RootView extends VerticalLayout {

    public RootView(StripeService stripeService) {
        setSpacing(true);

        add(new Label("Please enter your credit card details here:"));
        add(new StripeComponent(stripeService.getPublicKey()));
        add(new Label("Yes, you can trust me :)"));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
