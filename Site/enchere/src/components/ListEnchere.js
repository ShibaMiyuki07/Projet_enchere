import React, {useEffect, useState} from 'react'
import 'bootstrap/dist/css/bootstrap.min.css'
import EnchereService from '../service/EnchereService'

const ListEnchere=()=> {
    const[enchere, setEnchere] = useState([])

    useEffect(() => {
        EnchereService.getListEnchere().then((response) => {
            setEnchere(response.data)
            console.log(response.data);
        }).catch(error =>{
            console.log(error);
        })
    }, [])
  return (
    <div className="container">
        <h2 className="text-center">Liste des Encheres</h2>
        <table className="table">
            <thead>
                <th>idEnchere</th>
                <th>Categorie</th>
                <th>Date</th>
                <th>Prix Min</th>
                <th>Statut</th>
                <th>#</th>
            </thead>
            <tbody>
                {
                    enchere.map(
                        enchere =>
                        <tr key={enchere.idenchere}>
                            <td>{enchere.idenchere}</td>
                            <td>{enchere.idcategorie}</td>
                            <td>{enchere.dateheureenchere}</td>
                            <td>{enchere.prixminimum}</td>
                            <td>{enchere.etat}</td>
                            <td></td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListEnchere