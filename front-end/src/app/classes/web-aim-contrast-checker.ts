// cf. https://webaim.org/resources/contrastchecker/
// cf. https://webaim.org/resources/contrastchecker/contrast.js

export class WebAimContrastChecker {
  // take a foreground and background color to determine if they meet WCAG 2.0 level AA compliance;
  hasEnoughContrast (foregroudColor: string, backgroundColor: string): boolean {
    const foregroundLuminosity = this.getLuminosity(foregroudColor);
    const backgroundLuminosity = this.getLuminosity(backgroundColor);
    const maxLuminosity = Math.max(foregroundLuminosity, backgroundLuminosity);
    const minLuminosity = Math.min(foregroundLuminosity, backgroundLuminosity);
    const ratio = (maxLuminosity + 0.05) / (minLuminosity + 0.05);

    return ratio >= 4.5;
  }

  getLuminosity (color: string): number {
    const r = 0.2126 * this.getsRGB(color.substr(1, 2));
    const g = 0.7152 * this.getsRGB(color.substr(3, 2));
    const b = 0.0722 * this.getsRGB(color.substr(-2));

    return r + g + b;
  }

  getsRGB (color: string): number {
    const rgbColor = parseInt(color, 16) / 255;

    return rgbColor <= 0.03928
      ? rgbColor / 12.92
      : Math.pow(((rgbColor + 0.055) / 1.055), 2.4);
  }
}
