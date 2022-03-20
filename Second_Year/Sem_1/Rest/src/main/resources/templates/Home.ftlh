<!DOCTYPE html>
<html lang=en>
<head>
    <meta charset=UTF-8>
    <link rel="stylesheet" href="/Web_App2/resources/css/style.css">
</head>
<body>
<div class="form">
    <div class="tab-content">
        <div id="login">
            <h1>Welcome</h1>
            <form action="/Web_App2/longOut" method="post">
                <div class="field-wrap">
                    <label>
                        First Name : ${First_Name}<span class="req"></span>
                    </label>
                    <br>
                </div>
                <div class="field-wrap">
                    <label>
                        Last Name : ${Last_Name}<span class="req"></span>
                    </label>
                    <br>
                </div>
                <div class="field-wrap">
                    <br>
                </div>
                <button class="button button-block"/>
                Long out</button>
            </form>
        </div>
        <div id="signup">
            <h1>Sign Up for Free</h1>
        </div>
    </div>
</div>
</body>
</html>