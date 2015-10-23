package edu.holycross.shot.hexameter

class Foot {


  FootMeter meter;
  String footText;

  Foot () {
  }

  ArrayList syllablesMeter() {
    switch (this.meter) {
      case FootMeter.DACTYL:
      return [syllablesMeter.LONG, syllablesMeter.SHORT,syllablesMeter.SHORT]
      break

      case FootMeter.SPONDEE:
      return [syllablesMeter.LONG, syllablesMeter.LONG]
      break

      case FootMeter.ANCEPS:
      return [syllablesMeter.LONG, syllablesMeter.ANCEPS]
      break
    }
  }



}
