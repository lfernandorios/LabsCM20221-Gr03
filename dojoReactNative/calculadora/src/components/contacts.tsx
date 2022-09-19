import {IonCard,IonCardHeader,IonCardTitle, IonCardSubtitle, IonCardContent} from "@ionic/react"
import React from "react";
import { Contact } from "../models/contact.model";

const Contacts: React.FC<{contact: Contact}> = ({contact}) => {
    return (
        
        <IonCard>
            <IonCardHeader>
                <IonCardTitle>{contact.firstName}{contact.lastName}</IonCardTitle>
                <IonCardSubtitle>{contact.country}</IonCardSubtitle>
            </IonCardHeader>
            <IonCardContent>
                Email: {contact.email}
                Phone: {contact.phone}
            </IonCardContent>


        </IonCard>

        

    );
}

export default Contact