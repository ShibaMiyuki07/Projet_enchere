import { useState } from 'react';

import { Camera, CameraResultType, CameraSource } from '@capacitor/camera';

export interface UserPhoto {
    filepath: string;
    webviewPath?: string;
  }


export function usePhotoGallery() {
    const [photos, setPhotos] = useState<UserPhoto[]>([]);
    const takePhoto = async () => {
      const photo = await Camera.getPhoto({
        resultType: CameraResultType.DataUrl,
        source: CameraSource.Camera,
        quality: 100,
      });

      const fileName = new Date().getTime() + '.jpeg';
      const newPhotos = [
        {
            filepath: fileName,
            webviewPath: photo.dataUrl,
        },
  ...photos,
];
setPhotos(newPhotos);
    };
  
    return {
      photos,
      takePhoto,
    };
  }
