# network-utils
Library to handle network connectivity and internet availability

Your app might need to just check if there is any network connectivity available.
If network connectivity is available then it does not mean that internet over the network is available.

Your app might be interested in just checking network connectivity. This library supports below
network capabilities:

* WiFi
* Cellular
* Ethernet

In most cases app needs to check internet availability. For that you can just use below code:
```
if(NetworkUtils.hasInternet(context)) {
   //device has internet over WiFi or Cellular or Ethernet
}
```

```
if(NetworkUtils.hasInternetOverWifi(context)) {
//device has internet over WiFi network
}
```


```
if(NetworkUtils.hasInternetOverCellular(context)) {
//device has internet over Cellular network
}
```

```
if(NetworkUtils.hasInternetOverEthernet(context)) {
//device has internet over Ethernet network
}
```


If you are interested in checking network connectivity rather than internet availability. Use below code:

```
if(NetworkUtils.hasAnyNetworkCapability(context)) {
//device has WiFi or Cellular or Ethernet network connectivity
}
```


```
if(NetworkUtils.hasWifiCapability(context)) {
//device has WiFi network connectivity
}
```


```
if(NetworkUtils.hasCellularCapability(context)) {
//device has Cellular network connectivity
}
```

```
if(NetworkUtils.hasEthernetCapability(context)) {
//device has Ethernet network connectivity
}
```


Roadmaps:

- network checks
- internet checks
- observe WIFI network states - enabled, disabled, connected SSID, list of available SSID
- connnect to particular WIFI
