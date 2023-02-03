import React, { useState } from 'react';
import { IonContent, IonInput, IonTextarea, IonButton,IonGrid,IonRow,IonCol,IonImg, IonLabel, IonItem, IonSelect, IonSelectOption, useIonRouter} from '@ionic/react';
import {  useHistory } from "react-router-dom";
import { usePhotoGallery } from './Camera';
import axios from 'axios';




const liste_categorie = () =>
{
    const data = axios.get("https://projetenchere-production-5f54.up.railway.app/CategorieAdmin");
    return data;
}

const AjoutEnchere: React.FC = () => {
  const { photos, takePhoto } = usePhotoGallery();
  const history = useHistory();
  const [categorie, setCategorie] = useState('');
  const [description, setDescription] = useState('');
  const [minimumPrice, setMinimumPrice] = useState('');
  const [duration, setDuration] = useState('');
  const [liste_categoriee,setListeCategorie] = useState([]);
  const router = useIonRouter();



  const ajout_enchere = (props:any) =>
  {
    const id = localStorage.getItem("token");
    let iduser = null;
    if(id != null)
    {
      const json = JSON.parse(id);
      iduser = json.idutilisateur;
    }
    axios.post("https://projetenchere-production-5f54.up.railway.app/Enchere",{
      idutilisateur : iduser,
      idcategorie  : props.categorie,
      prix_min : props.prix_min+'.0',
      dureeenchere : props.dureeenchere,
      description : props.description,
      prixdevente :0
    }).then((data) => {
      router.push("/ListeEnchere","forward","push");
    });
  }



  liste_categorie().then(data => setListeCategorie(data.data)).catch(() => alert("Connexion impossible"));

  const ajout={
    categorie : categorie,
    description : description,
    prix_min : minimumPrice,
    dureeenchere : duration,

  };
  const submitForm=()=>{
    //alert(JSON.stringify('azo anaty base64'));
    const retour = takePhoto();
    console.log(retour);
  }

  return (
    <IonContent>
      <IonItem>
        <IonLabel position='floating'>Categorie</IonLabel>
        <IonSelect interface='popover' onIonChange={(e) => setCategorie(e.detail.value)}>
          {
            liste_categoriee.map( item =>{
              return(
                <IonSelectOption key={item["idcategorie"]} value={item["idcategorie"]}>{item['categorie']}</IonSelectOption>
              );
            })
          }
        </IonSelect>
        
      </IonItem>
      <IonItem>
        <IonLabel position='floating'>Desciption de l'objet</IonLabel>
        <IonTextarea 
          placeholder="Description de l'enchère"
          onIonChange={e => setDescription(e.detail.value!)}
        />
      </IonItem>
      <IonItem>
        <IonLabel position='floating'>Entrez le prix minimum de vente</IonLabel>
        <IonInput 
            placeholder="Prix minimum de vente"
            type="number"
            onIonChange={e => setMinimumPrice(e.detail.value!)}
          />
      </IonItem>
      <IonItem>
        <IonLabel position='floating'>Entree la duree de l'enchere(en mn)</IonLabel>
        <IonInput 
          placeholder="Durée de l'enchère (en minutes)"
          type="number"
          onIonChange={e => setDuration(e.detail.value!)}
        />
      </IonItem>
        
        <IonItem>
          <IonGrid>
            <IonRow>
              {photos.map((photo, index) => (
              <IonCol size="6" key={index}>
                  <IonImg src={photo.webviewPath} />
              </IonCol>
              ))}
            </IonRow>
        </IonGrid>

            <IonButton onClick={submitForm}>Ajouter une image</IonButton>
        </IonItem>
        <IonButton onClick={() => ajout_enchere(ajout)}>Valider</IonButton>
    </IonContent>
  );
};

export default AjoutEnchere;
