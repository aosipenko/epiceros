# epiceros-assignement

# How to run
mvn clean install
Options:
-Dwd.wait.timeout -> set web driver wait timeout in seconds. Default value 30 s.
-Ddriver.type -> select which browser to run. Possible options (if installed locally: CHROME, EDGE, FIREFOX, SAFARI). Default - CHROME.

Cases covered:
- Successful login with username and user email validatio
- Login form validation
- Password masking validation
- Bad username/password error (no text validation, just confirm its present)
- No username/password/both vlaidation )login btn must not be active
- Navigation from login to forgot password (had captcha, cound not do anything more)
- Navigation from login formto registration form (confirmation that registration is disaplyed)

# Code comments
- Stability can be optimized for async calls on profile page (for example, by using DevTools for chrome to ensure all HTTP calls are done processing or with some JS scripts)
- Overall stability can be improved with better knowledge of system events and scripting

# Important classes
- WebDriverFactory - creates and configures web drivers
- WebDriverFacade - used to avoid repeating endless ExpectedConditions across page objects
- LoginPage, UserHomePage, UserProfilePage -> page objects with distinct purpose and functionality
- LoginForm, RegistrationForm, SideMenuForm -> sub menues or popup forms inside bigger pages.
- Elements enums -> enums that contain page or form-specific selectors, quite useful to keep selector in one place and avoid spreading them across many classes
- SpringFramework is used to avoid complex inheritance or entity management. Also responsible for WebDriver shutdown through @PreDestroy annotation
- Other essential libs: Cucumber.io, testng, allure report

# Thoughts on coverage:
- Should have a case for registration of existing users (negative case - user must not be allowed to be registered)
- Should have a case for successful registration + login
- Password restoration flow
- Change email / username flow
- API tests for login endpoints (send invalid email, password with forbidden symbols, etc)

# Possible problem found:
- Maybe this was related to devs disabling captcha, but after failed login attempt cloudflare captcha was present, but login button remained active without passing cloudflare check. Perhaps worth investigating :)
- Call to /api/loginUser?clientName=Client+wunderinode+render passes on unencrypted user login and password {username: "qa_interview@mailinator.com", password: "testtest1", turnstileToken: "",…}

