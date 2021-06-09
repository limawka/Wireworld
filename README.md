# Wireworld
Simulator of a cellular automaton - Wireworld

# Input file format
Each line of the file must look like:
> Component_name x y [rotation] [x_2 y_2]  
> 
where the components is:
- ORGate, XORGate, ANDGate, Clock or Diode 
  - you can provite rotation: 0, 90, 180 or 270 degrees. Default is 0.
  - examples:
    - Diode 3 3
    - ORGate 10 5 180 
- Wire
  - the wire requires dwo points - x1, y1, x2, y2
  - example:
    - Wire 1 5 2 10
- ElectronHead, ElectronTail
  - only coordinates
  - example:
    - ElectronTail 5 5 
