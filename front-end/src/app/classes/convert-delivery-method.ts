export class ConvertDeliveryMethod {
  deliveryMethod = {
    electronicDisplaySource: ['Electronic PDF', 'Electronic Exchange'], // value to convert from;
    electronicDisplayTarget: 'Electronic' // value to convert to;
  };

  get (value: string): string {
    let returnValue = value;

    this.deliveryMethod.electronicDisplaySource.forEach(source => {
      returnValue = returnValue.replace(source, this.deliveryMethod.electronicDisplayTarget);
    });

    return returnValue;
  }
}
