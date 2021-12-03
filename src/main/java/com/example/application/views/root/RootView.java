package com.example.application.views.root;

import com.example.application.service.StripeService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("root")
@Route(value = "", layout = MainLayout.class)
public class RootView extends VerticalLayout {

    public RootView(StripeService stripeService) {
        stripeService.test();

        setSpacing(false);

        add(new Button("Click meh", e -> Notification.show("" + stripeService.getPublicKey())));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
