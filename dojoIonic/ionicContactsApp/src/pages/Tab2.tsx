import React, { useState } from 'react';
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar, IonList, IonButton } from '@ionic/react';
import { IonButtons, IonModal, IonItem, IonLabel, IonInput } from '@ionic/react';
import './Tab2.css';
import { Person } from '../models/person.model';
import EmployeeItem from '../components/EmployeeItem';

const Tab2: React.FC = () => {

  const [firstName, setFirstName] = useState<string>();
  const [lastName, setLastName] = useState<string>();
  const [email, setEmail] = useState<string>();
  const [country, setCountry] = useState<string>();
  const [phone, setPhone] = useState<string>();  
  
  const [showModal, setShowModal] = useState(false);

  const [people, setPeople] = useState<Person[]>([]);

  /*
  useIonViewDidEnter(async () => {
    for (let i = 0; i < 2; i++) {
      const result = await fetch('https://randomuser.me/api/');
      const data = await result.json();
      const information = data.results[0]
      const formatedObject = { "firstName": information.name.first, "lastName": information.name.last, "email": information.email, "country": information.location.country, "phone": information.phone }
      setPeople(people => [...people, formatedObject])
    }
  })*/


  function addContact() {
    console.log(firstName);
    const formatedObject = { "firstName": firstName, "lastName": lastName, "email": email, "country": country, "phone": phone }
    setPeople(people => [...people, formatedObject])
    console.log(formatedObject)
    setShowModal(false)
    
  }

  return (

    <IonPage>
      <IonHeader class="ion-margin-top">
        <IonToolbar >
          <IonTitle size="large" class="ion-text-center" >Contacts List</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent >
        
        <IonList>
          {people.map((person, idx) => <EmployeeItem key={idx} person={person} />)}
        </IonList>
      </IonContent>



      <IonButton onClick={() => setShowModal(true)} id="open-modal" expand="block">
        Create New Contact
      </IonButton>
      <IonModal isOpen={showModal} >
        <IonHeader>
          <IonToolbar>
            <IonButtons slot="start">
              <IonButton onClick={() => setShowModal(false)}>Cancel</IonButton>
            </IonButtons>
            <IonTitle>Create New Contact</IonTitle>
            <IonButtons slot="end">
              <IonButton strong={true} onClick={() => addContact()}>
                Confirm
              </IonButton>
            </IonButtons>
          </IonToolbar>
        </IonHeader>
        <IonContent className="ion-padding">
          <IonItem>
            <IonLabel position="stacked">Enter your first name</IonLabel>
            <IonInput type="text" placeholder="Your first name" onIonChange={e => setFirstName(e.detail.value!)}/>
          </IonItem>
          <IonItem>
            <IonLabel position="stacked">Enter your last name</IonLabel>
            <IonInput type="text" placeholder="Your last name" onIonChange={e => setLastName(e.detail.value!)}/>
          </IonItem>
          <IonItem>
            <IonLabel position="stacked">Enter your email</IonLabel>
            <IonInput type="text" placeholder="Your email" onIonChange={e => setEmail(e.detail.value!)}/>
          </IonItem>
          <IonItem>
            <IonLabel position="stacked">Enter your country</IonLabel>
            <IonInput type="text" placeholder="Your country" onIonChange={e => setCountry(e.detail.value!)}/>
          </IonItem>
          <IonItem>
            <IonLabel position="stacked">Enter your phone</IonLabel>
            <IonInput type="text" placeholder="Your phone" onIonChange={e => setPhone(e.detail.value!)}/>
          </IonItem>
        </IonContent>
      </IonModal>
      
    </IonPage>

  );
};

export default Tab2;
