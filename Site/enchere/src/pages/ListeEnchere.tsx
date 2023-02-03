import { IonContent, IonHeader, IonItem, IonList, IonTitle, IonToolbar } from '@ionic/react';
import axios from 'axios';
import React, { useEffect } from 'react';
import { useParams } from 'react-router';

const ListeEnchere: React.FC = () => {

  
const listeEnchere = (id : any) =>
{
  return axios.get("https://projetenchere-production-5f54.up.railway.app/Enchere").then( data2 =>
  {
    console.log(data2.data);
    return data2.data;
  });
}
    let id = JSON.stringify(useParams());
    var json = JSON.parse(id);
    const [user,setUser] = React.useState([]);
    useEffect(() => {
        listeEnchere(json.id).then(data => setUser(data));
      },[]);
  
    return (
        
        <IonContent>
          <IonHeader>
          <IonToolbar>
            <IonTitle>Liste Enchere en cours</IonTitle>
          </IonToolbar>
        </IonHeader>
        <IonList>
        <IonItem key={0}>
                <IonItem>Description</IonItem>
                <IonItem slot='end'>Date fin enchere</IonItem>
          </IonItem>
        {
          user.map( item => {
            return(
              <IonItem onClick={() => alert("mety")} key={item['idenchere']}>
                    <IonItem>{item['description']}</IonItem>
                   <IonItem slot='end'>{item['datefinenchere']}</IonItem>
              </IonItem>
            );
          })
          
        }
      </IonList>
        </IonContent>
    );
  };
  
  export default ListeEnchere;
  