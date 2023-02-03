import React, { useState } from 'react';
import { IonButton,IonContent, IonItem, IonLabel } from '@ionic/react';
import {IonInput} from '@ionic/react';
import { useHistory } from "react-router-dom";
import axios from 'axios';


const insertInscription = (props : any) =>
{
  const data = axios.post("https://projetenchere-production-5f54.up.railway.app/Utilisateur",{
    nom : props.nom,
    prenom : props.prenom,
    email : props.email,
    mdp : props.mdp
  }).then(() => window.location.href="/LoginUtilisateur");
}


const Inscription: React.FC = () => {
  const history = useHistory();
  const [nom, setNom] = useState('');
  const [prenom, setPrenom] = useState('');
  const [email, setEmail] = useState('');
  const [mdp, setMdp] = useState('');


  const utilisateur = {
    nom : nom,
    prenom : prenom,
    email : email,
    mdp : mdp
  };


  return (
    <IonContent>
        <IonItem>
          <IonLabel position='floating'>Entrez votre nom</IonLabel>
          <IonInput 
            placeholder="Nom"
            type="text"
            onIonChange={e => setNom(e.detail.value!)}
          />
        </IonItem>
        <IonItem>
        <IonLabel position='floating'>Entrez votre prenom</IonLabel>
          <IonInput 
            placeholder="Prenom"
            type="text"
            onIonChange={e => setPrenom(e.detail.value!)}
          />
        </IonItem>
        <IonItem>
        <IonLabel position='floating'>Entrez votre email</IonLabel>
          <IonInput 
            placeholder="email"
            type="text"
            onIonChange={e => setEmail(e.detail.value!)}
          />
        </IonItem>
        <IonItem>
        <IonLabel position='floating'>Entrez votre mot de passe</IonLabel>
          <IonInput 
            placeholder="Mot de passe"
            type="password"
            onIonChange={e => setMdp(e.detail.value!)}
          />
        </IonItem>
        
        <IonButton onClick={() => insertInscription(utilisateur)} type="submit">S'inscrire</IonButton>
    </IonContent>
  );
};

export default Inscription;
