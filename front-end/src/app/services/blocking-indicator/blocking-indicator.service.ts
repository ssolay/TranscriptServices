import { Injectable } from '@angular/core';
import { Overlay } from '@angular/cdk/overlay';
import { ComponentPortal } from '@angular/cdk/portal';
import { BlockingIndicatorComponent } from '../../components/blocking-indicator/blocking-indicator.component';
import { BlockingIndicatorRef } from '../../classes/blocking-indicator-ref';


@Injectable({
  providedIn: 'root'
})
export class BlockingIndicatorService {
  blockingRef: BlockingIndicatorRef;
  constructor(private overlay: Overlay) { }

  open() {
    if (this.blockingRef) {
      this.blockingRef.close();
    }
    // Create an Overlay ref
    const overlayRef = this.overlay.create({scrollStrategy: this.overlay.scrollStrategies.block()});
    // Create a BlockingIndicatorRef that we can close later
    this.blockingRef = new BlockingIndicatorRef(overlayRef);
    // Create a component that can be attached to the overlay
    const filePreviewPortal = new ComponentPortal(BlockingIndicatorComponent);
    // Attach the component to the overlay
    overlayRef.attach(filePreviewPortal);
    return this.blockingRef;
  }
  close() {
    if (this.blockingRef) { this.blockingRef.close(); }
  }
}
