import { IonApp, IonPage, IonRouterOutlet, IonSplitPane, setupIonicReact } from '@ionic/react';
import { IonReactRouter } from '@ionic/react-router';
import { Redirect, Route } from 'react-router-dom';
import Menu from './components/Menu';
import Page from './pages/Page';
import AjoutEnchere from './pages/AjoutEnchere';
import ListeEnchere from './pages/ListeEnchere';
import DemandeRechargement from './pages/DemandeRechargement';
import LoginUtilisateur from './pages/LoginUtilisateur';
import Inscription from './pages/Inscription';

/* Core CSS required for Ionic components to work properly */
import '@ionic/react/css/core.css';

/* Basic CSS for apps built with Ionic */
import '@ionic/react/css/normalize.css';
import '@ionic/react/css/structure.css';
import '@ionic/react/css/typography.css';

/* Optional CSS utils that can be commented out */
import '@ionic/react/css/padding.css';
import '@ionic/react/css/float-elements.css';
import '@ionic/react/css/text-alignment.css';
import '@ionic/react/css/text-transformation.css';
import '@ionic/react/css/flex-utils.css';
import '@ionic/react/css/display.css';
import OneSignal from 'onesignal-cordova-plugin'


/* Theme variables */
import './theme/variables.css';
import { useState } from 'react';

setupIonicReact();




const App: React.FC = () => {
  const[isConnected,setConnected]=useState(false);
  function OneSignalInit(): void {

    // NOTE: Update the setAppId value below with your OneSignal AppId.
    OneSignal.setAppId("30cdf2db-0abc-4fcd-b9a0-fa8e2cef546b");
    OneSignal.setNotificationOpenedHandler(function (jsonData) {
      console.log('notificationOpenedCallback: ' + JSON.stringify(jsonData));
    });
  
    // Prompts the user for notification permissions.
    //    * Since this shows a generic native prompt, we recommend instead using an In-App Message to prompt for notification permission (See step 7) to better communicate to your users what notifications they will get.
    OneSignal.promptForPushNotificationsWithUserResponse(function (accepted) {
      console.log("User accepted notifications: " + accepted);
    });

  }
  OneSignalInit();

  return (
    <IonApp>
      <IonReactRouter>
        <IonSplitPane contentId="main">
        <Menu connect={isConnected} connex={setConnected}/>
          <IonRouterOutlet id="main">
            <Route path="/" exact={true}>
              <Redirect to="/LoginUtilisateur" />
            </Route>
          <Route path="/AjoutEnchere" exact={true}>
            <IonPage>
              <Page connect={setConnected} bool={isConnected} />
              <AjoutEnchere />
            </IonPage>
          </Route>
          <Route path="/ListeEnchere" exact={true}>
            <IonPage>
              <Page connect={setConnected} bool={isConnected} />
              <ListeEnchere />
            </IonPage>
          </Route>
          <Route path="/DemandeRechargement" exact={true}>
            <IonPage>
              <Page connect={setConnected} bool={isConnected} />
              <DemandeRechargement />
            </IonPage>
          </Route>
          <Route path="/LoginUtilisateur" exact={true}>
            <IonPage>
              <Page connect={setConnected} bool={isConnected} />
              <LoginUtilisateur connect={setConnected}/>
            </IonPage>
          </Route>
          <Route path="/Inscription" exact={true}>
            <IonPage>
              <Page connect={setConnected} bool={isConnected} />
              <Inscription />
            </IonPage>
          </Route>
          </IonRouterOutlet>
        </IonSplitPane>
      </IonReactRouter>
    </IonApp>
  );
};

export default App;
