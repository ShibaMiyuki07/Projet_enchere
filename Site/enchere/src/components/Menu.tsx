import {
  IonContent,
  IonItem,
  IonList,
  IonListHeader,
  IonMenu,
  IonMenuToggle,
  IonNote,
  useIonRouter} from "@ionic/react";

import { useLocation } from "react-router-dom";
import "./Menu.css";





interface Connexion{connect:boolean,connex:Function}

const Menu: React.FC<Connexion> = ({connect,connex}) => {
  const location = useLocation();
  const autre = !connect;


  const router = useIonRouter();
  const Deconnexion = () =>{
    localStorage.removeItem("token");
    connex(false);
    router.push("/LoginUtilisateur","forward","push");
  }


  return (
    <IonMenu contentId="main" type="overlay">
      <IonContent>
        <IonList id="inbox-list">
          <IonListHeader>Enchere</IonListHeader>
          
              <IonMenuToggle autoHide={false}>

                {
                  autre?<div>
                    <IonItem
                  className={
                    location.pathname === '/Inscription' ? "selected" : ""
                    }
                    routerLink={'/Inscription'}
                    routerDirection="none"
                    lines="none"
                    detail={false}
                  >Inscription
                  </IonItem>
                  </div>:''
                }
                <IonItem
                  className={
                    location.pathname === '/ListeEnchere' ? "selected" : ""
                  }
                  routerLink={'/ListeEnchere'}
                  routerDirection="none"
                  lines="none"
                  detail={false}
                >Liste enchere
                </IonItem>
                  {connect?<div>
                    <IonItem
                  className={
                    location.pathname === '/AjoutEnchere' ? "selected" : ""
                  }
                  routerLink={'/AjoutEnchere'}
                  routerDirection="none"
                  lines="none"
                  detail={false}
                >Ajouter une enchere
                </IonItem>

                

                <IonItem
                  className={
                    location.pathname === '/DemandeRechargement' ? "selected" : ""
                  }
                 routerLink={'/DemandeRechargement'} 
                  routerDirection="none"
                  lines="none"
                  detail={false}
                >Demande rechargement
                </IonItem>
                <IonItem
                    className={
                      location.pathname === '/Inscription' ? "selected" : ""
                      }
                      onClick={() => Deconnexion()}
                      routerDirection="none"
                      lines="none"
                      detail={false}
                    >Deconnexion
                  </IonItem>
                  </div>: ''}
                  {
                  autre?<div>
                    <IonItem
                    className={
                      location.pathname === '/Inscription' ? "selected" : ""
                      }
                      routerLink={'/LoginUtilisateur'}
                      routerDirection="none"
                      lines="none"
                      detail={false}
                    >Connexion
                  </IonItem>
                  </div>:''
                }
              </IonMenuToggle>
        </IonList>

      
      </IonContent>
    </IonMenu>
  );
};

export default Menu;
