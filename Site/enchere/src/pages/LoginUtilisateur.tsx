import { IonButton, IonContent, IonHeader, IonInput, IonItem, IonLabel, IonTitle, IonToolbar, useIonRouter } from '@ionic/react';
import axios from 'axios';
import React from 'react';
import { useState } from 'react';
import Push from "push.js";





interface Connexion {connect:Function}
const LoginUtilisateur: React.FC<Connexion> = ({connect}) => {
const router = useIonRouter();
  const connexion = async (props : any,connect : Function) =>{
    axios.post("https://projetenchere-production-5f54.up.railway.app/Utilisateur/login",{
      email : props.email,
      mdp : props.mdp
    }).then((data) => {
      props.email = "";
      props.mdp = "";
      localStorage.setItem("token",JSON.stringify(data.data));
      connect(true);
      //Push.create("mety");
      router.push("/ListeEnchere","forward","push");
    }).catch((err) => {
      alert("L'utilisateur n'existe pas");
    });
  }

 
  
  const [user,setUser] = useState("");
  const [password,setPassword] = useState("");
  const utilisateur = {
    email : user,
    mdp : password
  };


  return (
      
      <IonContent>
        <IonHeader>
        <IonToolbar>
          <IonTitle>Veuillez vous connecter</IonTitle>
        </IonToolbar>
      </IonHeader>
          <IonItem>
            <IonLabel position='floating'>Email</IonLabel>
            <IonInput required type='text' value={user} onIonInput={(e:any) => setUser(e.target.value)}></IonInput>
          </IonItem>
          <IonItem>
            <IonLabel position='floating'>Mot de passe</IonLabel>
            <IonInput required type='password' value={password}  onIonInput={(e:any) => setPassword(e.target.value)}></IonInput>
          </IonItem>
          <IonItem><IonButton onClick={() => connexion(utilisateur,connect).then(() =>{
            setUser("");
            setPassword("");
          })}>Connect</IonButton></IonItem>
      </IonContent>
  );
};

export default LoginUtilisateur;
