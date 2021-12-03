import {html, LitElement} from 'lit';
import '@vaadin/text-field';
import '@vaadin/button';
import '@vaadin/horizontal-layout';
import '@vaadin/vertical-layout';
import {loadStripe} from '@stripe/stripe-js';

class StripeComponent extends LitElement {

    key: string | undefined;

    render() {
        return html`
            <vaadin-vertical-layout theme="padding spacing">
                <div id="card"></div>
                <vaadin-horizontal-layout id="button-container">
                    <vaadin-button
                            id="pay"
                            theme="primary"
                            on-click="submit"
                    >Pay
                    </vaadin-button>
                </vaadin-horizontal-layout>
            </vaadin-vertical-layout>
        `;
    }

    firstUpdated() {
        if (this.key != null) {
            loadStripe(this.key).then(
                stripe => {
                    if (stripe != null) {
                        const elements = stripe.elements();
                        const cardElement = elements.create("card");
                        cardElement.mount("#card");
                    }
                }
            );
        }
    }

    createRenderRoot() {
        return this;
    }

}

customElements.define('stripe-component', StripeComponent);