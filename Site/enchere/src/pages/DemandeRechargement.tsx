import React, { useState } from 'react';
import { IonContent, IonInput, IonTextarea, IonButton, IonItem, IonLabel, useIonRouter } from '@ionic/react';
import { useHistory } from "react-router-dom";
import axios from 'axios';

const insertionRechargement = (props : any)=>
{
  const id = localStorage.getItem("token");
  let iduser = null;
  if(id != null)
  {
    const json = JSON.parse(id);
    iduser = json.idutilisateur;
  }
  axios.post("https://projetenchere-production-5f54.up.railway.app/Rechargement",{
    idutilisateur : iduser,
    montantrecharge : props.solde
  });
}

const AjoutEnchere: React.FC = () => {
  const history = useHistory();
  const router = useIonRouter();
  const [solde, setSolde] = useState('');
  const props = {
    solde : solde
  }
  

  return (
    <IonContent>
        <IonItem>
          <IonLabel position='floating'>Entrez l'argent a recharger</IonLabel>
          <IonInput 
            placeholder="Solde demander"
            type="number"
            value={solde}
            onIonChange={e => setSolde(e.detail.value!)}
          />
        </IonItem>
        <IonItem>
          <IonButton onClick={() => {
            insertionRechargement(props);
            router.push("/ListeEnchere","forward","push")
          }}>Envoyer ma demande</IonButton>
        </IonItem>
    </IonContent>
  );
};

export default AjoutEnchere;
