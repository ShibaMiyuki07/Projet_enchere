import React, {useState} from 'react'
import { Link } from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.min.css'

const LoginUtilisateur=()=> {
  const[email,setEmail]=useState('')
  const[mdp,setMdp]=useState('')

  const btn_form=(e)=>{
    e.preventDefault()
    const utilisateur={email,mdp}
    fetch("http://localhost:8080/Utilisateur/login",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(utilisateur)
    }).then(()=>{
      console.log("Loger avec succes")
    })
  }
  return (
    <div className="App">
      <h1>Login User</h1><hr/>
      <center>
      <div className='col-md-3'>
        <form>
          <p><input className='form-control' type="email" placeholder="Email" value={email} onChange={(e)=>setEmail(e.target.value)}/></p>
          <p><input className='form-control' type="password" placeholder="Mot de passe" value={mdp} onChange={(e)=>setMdp(e.target.value)}/></p>
          <input className='btn btn-primary' type="submit" value="Log in" onClick={btn_form}/><br/>
          <Link to="/inscription" className="btn btn-info"> S'inscrire </Link>
        </form>
      </div>
      </center>
    </div>
  )
}



export default LoginUtilisateur