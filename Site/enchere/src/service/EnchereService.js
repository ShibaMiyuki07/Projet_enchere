import axios from "axios"

class EnchereService{
    getListEnchere(){
        return axios.get("http://localhost:8080/Enchere/All")
    }
}
export default new EnchereService()