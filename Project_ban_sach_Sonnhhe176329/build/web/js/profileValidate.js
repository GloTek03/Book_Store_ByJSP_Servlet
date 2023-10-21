function showChangeButton() {
    var btn = document.getElementById("submit");
    btn.style.display = "block";
}

function validateForm() {
    var pass = $("#updateForm").data('value');
    var phone = document.forms["updateForm"]["phone"].value;
    var currPass = document.forms["updateForm"]["currpass"].value;
    var i = 0;
    //Check Phone number
    const regexPhone = new RegExp('(0[3|5|7|8|9])+([0-9]{8})+(\\b)');
    var phoneF = document.getElementById("phoneFail");
    if (regexPhone.test(phone)) {
        phoneF.style.display = "none";
    } else {
        document.getElementById("phoneFail").innerHTML = "Invalid format (must 10 number [0-9] and not contain character)";
        phoneF.style.display = "block";
        i++;
    }
    //Check match current Password
    var passF = document.getElementById("passFail");
    if (currPass == pass) {
        passF.style.display = "none";
    } else {
        document.getElementById("passFail").innerHTML = "Wrong password!";
        passF.style.display = "block";
        i++;
    }
    //Return
    if (i == 0) {
        return true;
    } else {
        return false;
    }
}