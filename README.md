# network-utils
Library to handle network connectivity and internet availability

Your app might need to just check if there is any network connectivity available.
If network connectivity is available then it does not mean that internet over the network is available.

Your app might be interested in just checking network connectivity. This library supports below
network capabilities:

* WiFi
* Cellular
* Ethernet

## Setup

### Step 1
Add it in your root build.gradle at the end of repositories:

```
allprojects {
repositories {
   maven { url 'https://jitpack.io' }
  }
}
```
### Step 2
Add the dependency

```
dependencies {
	 implementation 'com.github.bharatsunel:network-utils:Tag'
	}
```
## Initialize sdk in application onCreate

```
NetworkUtils.init(this)
```

## In most cases app needs to check internet availability. For that you can just use below code:
```
if(NetworkUtils.hasInternet()) {
   //device has internet over WiFi or Cellular or Ethernet
}
```

## If you are interested in checking network connectivity rather than internet availability. Use below code:

```
if(NetworkUtils.hasNetwork()) {
//device has WiFi or Cellular or Ethernet network connectivity
}
```
