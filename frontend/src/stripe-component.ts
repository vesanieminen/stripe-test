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

            <style include="shared-styles">
                #card {
                    width: 300px;
                }
            </style>


            <vaadin-vertical-layout>

                <vaadin-horizontal-layout>
                    <div id="card"></div>
                </vaadin-horizontal-layout>

                <vaadin-vertical-layout>
                    <vaadin-button
                            id="buy"
                            theme="primary"
                            on-click="submit"
                    >Buy
                    </vaadin-button>

                </vaadin-vertical-layout>
            </vaadin-vertical-layout>


        `;
    }

    firstUpdated() {
        if (this.key != null) {
            const stripe = loadStripe(this.key).then(
                e => {
                    if (e != null) {
                        const elements = e.elements();
                        const cardElement = elements.create("card", {
                            hidePostalCode: true
                        });
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