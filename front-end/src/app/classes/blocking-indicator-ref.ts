import { OverlayRef } from '@angular/cdk/overlay';

export class BlockingIndicatorRef {

  constructor(private overlayRef: OverlayRef) { }

  close(): void {
    this.overlayRef.dispose();
  }
}
