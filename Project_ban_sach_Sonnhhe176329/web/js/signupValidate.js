function validateForm() {
    var username = document.forms["register-form"]["username"].value;
    var fullname = document.forms["register-form"]["fullname"].value;
    var email = document.forms["register-form"]["email"].value;
    var phone = document.forms["register-form"]["phone"].value;
    var address = document.forms["register-form"]["address"].value;
    var password = document.forms["register-form"]["password"].value;
    var repass = document.forms["register-form"]["repassword"].value;
    
    var i = 0;
    
//    Check validate Username
    const regexUser = new RegExp('[^a-z0-9]');  
    var user = document.getElementById("userFail");
    if (regexUser.test(username)) {
        document.getElementById("userFail").innerHTML = "Invalid format (must contain [a-z] or [0-9])";
        user.style.display = "block";
        i++;
    } else {
        user.style.display = "none";
    }
//  Check validate Fullname
    const regexFullname = new RegExp('[0-9]');
    var name = document.getElementById("fullnameFail");
    if (regexFullname.test(fullname)) {
        document.getElementById("fullnameFail").innerHTML = "Invalid format (must not contain [0-9])";
        name.style.display = "block";
        i++;
    } else {
        name.style.display = "none";
    }
//  Check validate Phonenumber    
    const regexPhone = new RegExp('(0[3|5|7|8|9])+([0-9]{8})+(\\b)');
    var phoneF = document.getElementById("phoneFail");
    if (regexPhone.test(phone)) {
        phoneF.style.display = "none";      
    } else {
        document.getElementById("phoneFail").innerHTML = "Invalid format (must 10 number [0-9] and not contain character)";
        phoneF.style.display = "block";
        i++;
    }
//  Check match Re-password
    var rep = document.getElementById("repassFail");
    if (repass === password) {
        rep.style.display = "none";   
    } else {
        document.getElementById("repassFail").innerHTML = "Password not match";
        rep.style.display = "block";
        i++;
    }
//////////////////////
    if(i == 0){
        return true;
    } else {
        return false;      
    }

}