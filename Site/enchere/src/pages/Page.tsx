import { IonButton, IonButtons, IonHeader, IonItem, IonMenuButton, IonTitle, IonToolbar, useIonRouter } from '@ionic/react';
import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router';
import './Page.css';

interface Connexion{connect:Function,bool : boolean}

const getSolde = async () =>{
  const user = localStorage.getItem("token");
  let token = null;
  if(user != null)
  {
    const json = JSON.parse(user);
    token = json.token;
  }
  const data = axios.get("https://projetenchere-production-5f54.up.railway.app/Utilisateur/solde/"+token);
  console.log((await data).data);
  return (await data).data;
}

const Page: React.FC<Connexion> = ({connect,bool}) => {
  const router = useIonRouter();
  const [solde,setSolde] = useState(0);
  const [co,setCo] = useState(false);
  const { name } = useParams<{ name: string; }>();
  useEffect(() =>{
    setCo(bool);
    if(bool == true)
    {
      getSolde().then(data => setSolde(data));
    }
  });

  const Button = (props :any) =>
  {
    if(props.bool === true)
    {
      
      return(
        <IonItem slot='end'>Solde actuelle :{solde} Ar</IonItem>
      );
    }
    else{
      return (
        <IonItem></IonItem>
      );
    }
  }

  const deconnexion = (co : Function) =>
{
  co(false);
  router.push("/LoginUtilisateur","forward","push");
}




  return (
      <IonHeader>
        <IonToolbar>
          <IonButtons slot="start">
            <IonMenuButton />
          </IonButtons>
          <IonTitle>{name}</IonTitle>
          <Button bool ={co} connex = {connect}/>
        </IonToolbar>
      </IonHeader>
  );
};

export default Page;
