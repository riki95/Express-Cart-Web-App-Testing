# Express Cart Web App Testing
expressCart is a fully functional shopping cart built in Node.js (Express, MongoDB) with Stripe, PayPal and Authorize.net payments. This is a Web App Testing for expressCart.

## Getting Started
First of all you need to install expressCart and you find everything here:

```
https://github.com/mrvautin/expressCart
```
For the testing we will use Selenium Web Driver and Chrome as Browser. It is important that you download the Chromedriver here:
```
https://sites.google.com/a/chromium.org/chromedriver/
```
Place it wherever you want but remember that you will have to modify the path for it, I will tell you later how. Preferable path: Desktop.

And finally, download my repo which is the testing suite for expressCart:
```
git clone https://github.com/riki95/Express-Cart-Web-App-Testing
```
The main problem of this WebApp test is that I've tested it with some elements already uploaded on the website. As soon as you download and install expressCart, the website will be empty. Try to upload elements and fill at least 2 pages, then some of the tests will work. The other ones need to be seen one by one in order to understand what they're doing exactly.

## Authors

* **Riccardo Basso** - Università degli studi di Genova
