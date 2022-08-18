$(document).ready(function () {
    $.validator.addMethod('capitals', function(thing){
        return thing.match(/[A-Z]/);
    });

    $.validator.addMethod('emailPattern', function(thing2){
        return thing2.match(/[a-z0-9]+@+[a-z0-9]+.com/);
    });

    $("form").validate({

        rules : {
            userName : {
                required : true
            },
            password : {
                required : true,
                minlength: 8,
                capitals: true,
            },
            confirmPassword : {
                required : true,
                equalTo : "#password"
            },
            email : {
                required:true,
                emailPattern:true,
            }
        },
        messages : {
            password: {
                minlength: "Password too short, make it at least 8 characters",
                capitals: "Field must contain a capital letter",
            },
            confirmPassword : {
                equalTo : "Passwords do not match"
            },
            email : {
                emailPattern: "Email must be entered in the formal xxxxxx@yyyyy.com"
            }
        },
        errorClass : "error"
    });
});