import React from 'react'
import {  IonCard, IonCardHeader, IonCardSubtitle, IonCardTitle, IonCardContent } from '@ionic/react'
import { Person } from '../models/person.model'

const EmployeeItem: React.FC<{ person: Person }> = ({ person }) => {
   
    return (
        <IonCard>
            <IonCardHeader>
                <IonCardTitle>{person.firstName} {person.lastName}</IonCardTitle>
                <IonCardSubtitle>{person.country}</IonCardSubtitle>
            </IonCardHeader>
            <IonCardContent>
                Email: {person.email}<br/>
                Phone: {person.phone}
            </IonCardContent>
        </IonCard>
    )
}

export default EmployeeItem;

