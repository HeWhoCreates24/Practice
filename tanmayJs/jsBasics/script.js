class user {
    constructor(name, mail){
        this.name = name;
        this.mail = mail;
    }
    viewData(str) {
        if (str === "name"){
            return this.name;
        }
        else if (str === "mail"){
            return this.mail;
        }
        else{
            return "WTF do you want?"
        }
    }
}
class admin extends user {
    editData(str) {
        if (str === "name"){
            this.name = prompt("enter new name");
            return this.name;
        }
        else if (str === "mail"){
            this.mail = prompt("enter new mail");
            return this.mail;
        }
        else{
            return "WTF do you want?"
        }
    }
}