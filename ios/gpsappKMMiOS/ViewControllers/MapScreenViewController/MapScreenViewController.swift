import UIKit
import MapKit

final class MapScreenViewController: UIViewController, CLLocationManagerDelegate {
    
    @IBOutlet private weak var mapView: MKMapView!
    @IBOutlet private weak var txtLat: UITextField!
    @IBOutlet private weak var txtLng: UITextField!
    
    let locationManger = CLLocationManager()
    let coordinateSwedenMapView = CLLocationCoordinate2D (latitude: 59.3194903, longitude: 18.075060000000007)
    let regionInMeters: Double = 350
    var currentCoordinates = CLLocationCoordinate2D(
        latitude: 0, longitude: 0)
    
    init() {
        super.init(nibName: String(describing: MapScreenViewController.self), bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func viewDidLoad() {
        mapView.setRegion(MKCoordinateRegion(center: coordinateSwedenMapView,
                                             span: MKCoordinateSpan(latitudeDelta: 0.08, longitudeDelta: 0.08)), animated: false)
        
        checkLocationServices()
        mapView.mapType = .satellite
        mapView.delegate = self
        
        let tapGestureRecognizer = UITapGestureRecognizer()
        tapGestureRecognizer.numberOfTapsRequired = 1
        tapGestureRecognizer.addTarget(self, action: #selector(addPinAnnotation(_:)))
        
        mapView.addGestureRecognizer(tapGestureRecognizer)
    }
    
    internal func mapView(_ mapView: MKMapView, viewFor annotation: MKAnnotation) -> MKAnnotationView? {
        guard annotation is MKPointAnnotation else { return nil }
        
        let identifier = "Annotation"
        var annotationView = mapView.dequeueReusableAnnotationView(withIdentifier: identifier)
        
        if annotationView == nil {
            annotationView = MKPinAnnotationView(annotation: annotation, reuseIdentifier: identifier)
            annotationView!.canShowCallout = true
        } else {
            annotationView!.annotation = annotation
        }
        return annotationView
    }
    
    private func setupLocationManger() {
        locationManger.delegate = self
        locationManger.desiredAccuracy = kCLLocationAccuracyBest
    }
    
    private func addCurrentPin() {
        let pin = MKPointAnnotation()
        pin.coordinate = currentCoordinates
        mapView.addAnnotation(pin)
    }
    
    private func zoomInViewOnUserLocation () {
        if IOSFormViewModel.shared.formViewModel.currentState.form.data.coordinates.latitude != nil {
            let latitude = IOSFormViewModel.shared.formViewModel.currentState.form.data.coordinates.latitude as! CLLocationDegrees
            let longitude = IOSFormViewModel.shared.formViewModel.currentState.form.data.coordinates.longitude  as! CLLocationDegrees
            let region = MKCoordinateRegion.init(center: CLLocationCoordinate2D(latitude: latitude, longitude: longitude), latitudinalMeters: regionInMeters, longitudinalMeters: regionInMeters)
            
            mapView.setRegion(region, animated: true)
            txtLat.text = ("  lat: \(latitude)")
            txtLng.text = ("  lon: \(longitude)")
            addCurrentPin()
            currentCoordinates = CLLocationCoordinate2D(
                latitude: latitude, longitude: longitude)
        }else{
            if let location = locationManger.location?.coordinate {
                let region = MKCoordinateRegion.init(center: location, latitudinalMeters: regionInMeters, longitudinalMeters: regionInMeters)
                mapView.setRegion(region, animated: true)
            }
        }
    }
    
    private func checkLocationServices() {
        if CLLocationManager.locationServicesEnabled(){
            setupLocationManger()
            checkLocationAuthorization()
            zoomInViewOnUserLocation()
        } else {
        }
    }
    
    private func checkLocationAuthorization() {
        switch CLLocationManager.authorizationStatus() {
        case .authorizedWhenInUse:
            mapView.showsUserLocation = true
            locationManger.delegate = self
            locationManger.startUpdatingLocation()
        case .denied:
            break
        case .notDetermined:
            locationManger.requestWhenInUseAuthorization()
        case .restricted:
            break
        case .authorizedAlways:
            break
        }
    }
    
    internal func locationManagerDidChangeAuthorization(_ manager: CLLocationManager) {
        checkLocationServices()
    }
    
    @objc
    func addPinAnnotation(_ sender: UITapGestureRecognizer) {
        
        let location = sender.location(in: self.mapView)
        let locCoord = self.mapView.convert(location, toCoordinateFrom: self.mapView)
        let lat:Double = locCoord.latitude
        let lng:Double = locCoord.longitude
        
        IOSFormViewModel.shared.formViewModel.setCoordinates(latitude: lat, longitude: lng)
        
        txtLat.text = ("  lat: \(lat)")
        txtLng.text = ("  lon: \(lng)")
        
        zoomInViewOnUserLocation()
        let annotation = MKPointAnnotation()
        
        annotation.coordinate = locCoord
        
        self.mapView.removeAnnotations(mapView.annotations)
        self.mapView.addAnnotation(annotation)
    }
}

extension MapScreenViewController: MKMapViewDelegate {
    func mapViewWillStartLoadingMap(_ mapView: MKMapView) {
        print(#function)
    }
    
    func mapViewDidChangeVisibleRegion(_ mapView: MKMapView) {
        
    }
}
